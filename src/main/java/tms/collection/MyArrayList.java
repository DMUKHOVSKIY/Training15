package tms.collection;

import java.util.ArrayList.*;


public class MyArrayList<T> implements MyList<T> {

    private Object[] elements = new Object[10];
    private int size = 0;

    private void grow() {
        //Копируем в новый массив все элементы из старого массива и заменяем ссылку
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public void add(T o) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = o;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public T remove(int index) {
        //Удалить по индексу и сдвинуть влево
        T element = (T) elements[index];
        for (int i = index; i < size-1;) {
                elements[i] = elements[++i];
        }
        elements[size-1] = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }
}
