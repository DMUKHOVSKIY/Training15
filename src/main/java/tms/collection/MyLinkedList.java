package tms.collection;

import java.util.LinkedList;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T o) {
        Node<T> oldTail = tail;
        Node<T> next = new Node(o, null, oldTail);
        tail = next;
        if (oldTail == null) {
            head = next;
        } else {
            oldTail.next = next;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).object;
    }

    @Override
    public T remove(int index) {
        checkElementIndex(index);
        Node<T> oldElement = node(index);
        Node<T> before = oldElement.prev;
        Node<T> after = oldElement.next;

        T object = oldElement.object;

        if (before == null) {
            after = head;
        } else {
            before.next = after;
            oldElement.prev = null;
        }

        if (after == null) {
            before = tail;
        } else {
            after.prev = before;
            oldElement.next = null;
        }

        oldElement.object = null;
        size--;
        return object;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException();
    }

    private Node<T> node(int index) {
        if (index < (size / 2)) {
            Node<T> head1 = head;
            for (int i = 0; i < index; i++) {
                head1 = head1.next;
            }
            return head1;
        } else {
            Node<T> tail1 = tail;
            for (int i = size - 1; i > index; i--) {
                tail1 = tail1.prev;
            }
            return tail1;
        }
    }

    private static class Node<T> {
        T object;
        Node<T> next;
        Node<T> prev;

        public Node(T object, Node<T> next, Node<T> prev) {
            this.object = object;
            this.next = next;
            this.prev = prev;
        }
    }
}
