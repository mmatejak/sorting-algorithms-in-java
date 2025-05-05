package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MergeSort {

    // Próg dla przełączenia na sortowanie przez wstawianie
    private static final int INSERTION_SORT_THRESHOLD = 10;

    // Metoda główna do sortowania tablicy przy użyciu algorytmu Merge Sort
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // Tablica jest pusta lub zawiera jeden element, jest już posortowana
        }
        sort(array, 0, array.length - 1);
    }

    // Metoda pomocnicza do sortowania podtablicy od left do right
    private static void sort(int[] array, int left, int right) {
        // Dla małych podtablic używamy sortowania przez wstawianie
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(array, left, right);
            return;
        }

        if (left < right) {
            // Znalezienie środka podtablicy
            int middle = left + (right - left) / 2;

            // Sortowanie lewej i prawej połowy
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Scalanie posortowanych połówek
            merge(array, left, middle, right);
        }
    }

    // Sortowanie przez wstawianie dla małych podtablic
    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    // Metoda do scalania dwóch posortowanych podtablic
    private static void merge(int[] array, int left, int middle, int right) {
        // Wielkość lewej i prawej podtablicy
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        // Tworzenie tymczasowych tablic
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Kopiowanie danych do tymczasowych tablic
        System.arraycopy(array, left, leftArray, 0, leftSize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightSize);

        // Indeksy do iteracji przez tablice
        int i = 0, j = 0, k = left;

        // Scalanie tablic tymczasowych z powrotem do tablicy głównej
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Kopiowanie pozostałych elementów z lewej podtablicy
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        // Kopiowanie pozostałych elementów z prawej podtablicy
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }
}
