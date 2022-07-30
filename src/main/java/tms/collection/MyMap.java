package tms.collection;

public interface MyMap<K, V> {
    V put(K key, V value); //If the elements with the same keys. "Put" return old value, but new is replaced
    V remove (K key);
    V get (K key);
    int size();

}
