package task2;

import java.util.Comparator;

class SkewHeap<T> {
    private final Comparator<T> comparator;
    private Node<T> root;
    public SkewHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public void add(T value) {
        root = merge(root, new Node<>(value));
    }

    public T poll() {
        if (root == null) return null;
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
        h1.right = merge(h1.right, h2);
        Node<T> temp = h1.left;
        h1.left = h1.right;
        h1.right = temp;
        return h1;
    }

    private static class Node<T> {
        T value;
        Node<T> left, right;

        Node(T value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

}