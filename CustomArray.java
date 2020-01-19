package com.crossover.demo;

public class CustomArray {
    private final int[] _array;

    public CustomArray(int[] array) {
        _array = array;
    }

    public void sort() {
        int size = _array.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if (_array[i] > _array[j]) {
                   int temp = _array[i];
                   _array[i] = _array[j];
                   _array[j] = temp;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < _array.length; i++)
            System.out.println(_array[i] + " ");
    }
}
