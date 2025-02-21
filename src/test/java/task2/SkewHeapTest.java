package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SkewHeapTest {
    @Test
    void testAddAndPoll() {
        SkewHeap<Integer> heap = new SkewHeap<>(Integer::compareTo);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);

        assertEquals(1, heap.poll());
        assertEquals(3, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(8, heap.poll());
        assertNull(heap.poll());
    }

    @Test
    void testPeek() {
        SkewHeap<Integer> heap = new SkewHeap<>(Integer::compareTo);
        assertNull(heap.peek());
        heap.add(7);
        assertEquals(7, heap.peek());
        heap.add(3);
        assertEquals(3, heap.peek());
    }

    @Test
    void testIsEmpty() {
        SkewHeap<Integer> heap = new SkewHeap<>(Integer::compareTo);
        assertTrue(heap.isEmpty());
        heap.add(4);
        assertFalse(heap.isEmpty());
    }
}
