package tms.collection;

import java.util.HashMap.*;

import java.util.Map;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Node<K, V>[] table = new Node[5];
    private int size = 0;
    private int length = table.length;

    private void resize() {
        Node[] newTable = new Node[grow()];


        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                newTable[getIndex(node.key)] = node;
                node = node.next;
            }
        }
        table = newTable;
    }

    private int grow() {
        length = length * 2;
        return length;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        int index = hash % length;
        return Math.abs(index);
    }

    @Override
    public V put(K key, V value) {
        if (table.length == size) {
            resize();
        }
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new Node(key, value, null);
        } else {
            Node<K, V> head = table[index];
            Node<K, V> head1 = head;
            while (head != null) {
                if (head.key.equals(key)) {
                    V v = head.setValue(value);
                    return value;
                }
                head = head.next;
            }
            table[index] = new Node(key, value, null);
            table[index].next = head1;
        }
        size++;
        return value;
    }

    @Override
    public V remove(K key) {
        V value = null;
        int index = getIndex(key);
        Node<K, V> head = table[index];
        if (head != null) {
            if (head.next == null) {
                value = head.value;
                table[index] = null;
            } else {
                Node<K, V> prev = null;
                while (head != null) {
                    if (head.key.equals(key)) {
                        value = head.value;
                        if (prev == null) {
                            table[index] = head.next;
                        } else {
                            prev.next = head.next;
                        }
                        head.next = null;
                        head.value = null;
                        head.key = null;

                        return value;
                    }
                    prev = head;
                    head = head.next;
                }
            }
            return value;
        }
        return null;
    }


    @Override
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = table[index];
        if (head != null) {
            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> implements Map.Entry<K, V> {

        K key;
        V value;

        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
