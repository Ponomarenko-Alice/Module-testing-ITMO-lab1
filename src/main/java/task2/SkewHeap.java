package task2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SkewHeap<T> {
    private static class Node<T> {
        T value;
        Node<T> left, right;

        Node(T value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node<T> root;
    private final Comparator<T> comparator;
    @Getter
    private final List<String> trace;

    public SkewHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.trace = new ArrayList<>();
    }

    public void add(T value) {
        trace.add("Adding: " + value);
        root = merge(root, new Node<>(value));
    }

    public T poll() {
        if (root == null) return null;
        trace.add("Polling: " + root.value);
        T minValue = root.value;
        root = merge(root.left, root.right);
        return minValue;
    }

    public T peek() {
        return root == null ? null : root.value;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> merge(Node<T> h1, Node<T> h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        if (comparator.compare(h1.value, h2.value) > 0) {
            Node<T> temp = h1;
            h1 = h2;
            h2 = temp;
        }
        trace.add("Merging: " + h1.value + " and " + (h2 != null ? h2.value : "null"));
        h1.right = merge(h1.right, h2);
        Node<T> temp = h1.left;
        h1.left = h1.right;
        h1.right = temp;
        return h1;
    }

}