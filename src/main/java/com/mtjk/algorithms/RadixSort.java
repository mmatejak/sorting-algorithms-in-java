package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RadixSort {

    private static final int CUTOFF_THRESHOLD = 15;
    private static final int INT_BITS = 32;
    private static final int BYTE_BITS = 8;
    private static final int RADIX = 256;

    // Metoda sortowania przy użyciu algorytmu Radix Sort
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // Tablica jest pusta lub ma tylko jeden element, więc jest już posortowana
        }

        int[] auxiliaryArray = new int[array.length];
        int partitionIndex = partition(0, array, 0, array.length - 1);

        if (partitionIndex > 0) {
            // Sortowanie przedziału, który zawiera wartości nieujemne i przedziału z wartościami ujemnymi
            recursiveSort(array, partitionIndex, array.length - 1, 0, auxiliaryArray);
            recursiveSort(array, 0, partitionIndex - 1, 0, auxiliaryArray);
        } else {
            // Sortowanie całej tablicy, jeśli wszystkie wartości są nieujemne
            recursiveSort(array, 0, array.length - 1, 0, auxiliaryArray);
        }
    }

    // Metoda do podziału tablicy wokół pivota
    public static int partition(int pivot, int[] array, int low, int high) {
        int left = low;
        int right = high;

        while (left < right) {
            while (array[left] < pivot) {
                if (++left > high) return high + 1;
            }

            while (array[right] > pivot) {
                if (--right < low) return low - 1;
            }

            if (left < right) {
                swap(array, left, right);
                if (array[left] != pivot) left++;
                if (array[right] != pivot) right--;
            }
        }
        return left;
    }

    // Rekurencyjna metoda sortowania z użyciem algorytmu Radix Sort
    private static void recursiveSort(int[] array, int low, int high, int digitIndex, int[] auxiliaryArray) {
        if (digitIndex > 4) return; // Maksymalna liczba cyfr do sortowania
        if (high - low < CUTOFF_THRESHOLD) {
            insertionSort(array, low, high);
            return;
        }

        int[] count = new int[RADIX + 1];

        // Obliczanie liczby wystąpień dla każdego bajtu
        int shiftBits = INT_BITS - BYTE_BITS * digitIndex - BYTE_BITS;
        int mask = 0xFF;
        for (int i = low; i <= high; i++) {
            int digit = (array[i] >> shiftBits) & mask;
            count[digit + 1]++;
        }

        // Obliczanie indeksów
        for (int i = 0; i < RADIX; i++) {
            count[i + 1] += count[i];
        }

        // Rozdzielanie elementów do koszy
        for (int i = low; i <= high; i++) {
            int digit = (array[i] >> shiftBits) & mask;
            auxiliaryArray[count[digit] + low] = array[i];
            count[digit]++;
        }

        // Kopiowanie posortowanych elementów z powrotem do tablicy
        System.arraycopy(auxiliaryArray, low, array, low, high - low + 1);

        // Rekurencyjne sortowanie koszy
        if (count[0] > 0) {
            recursiveSort(array, low, low + count[0] - 1, digitIndex + 1, auxiliaryArray);
        }
        for (int i = 1; i < RADIX; i++) {
            if (count[i] > 0) {
                recursiveSort(array, low + count[i - 1], low + count[i] - 1, digitIndex + 1, auxiliaryArray);
            }
        }
    }

    // Sortowanie przez wstawianie dla zakresu a[low..high], zaczynając od d-tego bajtu
    private static void insertionSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Metoda do zamiany dwóch elementów w tablicy
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
