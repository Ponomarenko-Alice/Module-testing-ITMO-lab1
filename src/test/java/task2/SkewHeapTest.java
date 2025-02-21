package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SkewHeapTest {

    @Test
    void testMultipleAddsAndPolls() {
        SkewHeap<Integer> heap = new SkewHeap<>(Integer::compareTo);
        heap.add(15);
        heap.add(25);
        heap.add(5);
        heap.add(30);
        heap.add(2);

        assertEquals(2, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(15, heap.poll());
        assertEquals(25, heap.poll());
        assertEquals(30, heap.poll());
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
        heap.add(10);
        assertEquals(3, heap.peek());
    }

    @Test
    void testIsEmpty() {
        SkewHeap<Integer> heap = new SkewHeap<>(Integer::compareTo);
        assertTrue(heap.isEmpty());
        heap.add(4);
        assertFalse(heap.isEmpty());
        heap.poll();
        assertTrue(heap.isEmpty());
    }
}
