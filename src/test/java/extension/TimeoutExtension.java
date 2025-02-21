package extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public class TimeoutExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static long maxTimeout;

    static {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("src/timeout.config")));
            maxTimeout = Long.parseLong(properties.getProperty("max.timeout"));
        } catch (IOException e) {
            System.out.println("Failed to read config file" + e.getMessage());
        }
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        context.getStore(ExtensionContext.Namespace.GLOBAL).put("startTime", System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws TimeoutException {
        long startTime = context.getStore(ExtensionContext.Namespace.GLOBAL).get("startTime", Long.class);
        long duration = System.currentTimeMillis() - startTime;

        if (duration > maxTimeout) {
            throw new TimeoutException("Test " + context.getDisplayName() + " exceeded the maximum timeout of " + maxTimeout + " ms");
        }
    }
}
