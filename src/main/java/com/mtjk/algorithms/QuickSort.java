package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuickSort {

    // Metoda sortowania tablicy przy użyciu algorytmu Quick Sort
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Znalezienie indeksu pivota z użyciem metody median-of-three
            int pivotIndex = partition(array, low, high);

            // Rekurencyjne sortowanie części przed i po pivocie
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Metoda do wyboru pivota używając strategii median-of-three
    private static int medianOfThree(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sortowanie trzech elementów: low, mid, high
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }

        // Teraz array[mid] jest medianą z trzech elementów
        // Zamieniamy ją z przedostatnim elementem, aby nie zakłócać partycjonowania
        swap(array, mid, high - 1);
        return array[high - 1];
    }

    // Metoda do podziału tablicy na dwie części wokół pivota
    private static int partition(int[] array, int low, int high) {
        // Jeśli mamy wystarczająco dużo elementów, używamy median-of-three
        int pivot;
        if (high - low > 2) {
            pivot = medianOfThree(array, low, high);
            // Pivot jest teraz na pozycji high-1
            high = high - 1;
        } else {
            pivot = array[high]; // Dla małych tablic używamy ostatniego elementu
        }

        int smallerElementIndex = low - 1; // Indeks mniejszego elementu

        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            // Jeśli bieżący element jest mniejszy lub równy pivotowi
            if (array[currentIndex] <= pivot) {
                smallerElementIndex++;

                // Zamiana elementów
                swap(array, smallerElementIndex, currentIndex);
            }
        }

        // Zamiana pivota z elementem na pozycji smallerElementIndex + 1
        swap(array, smallerElementIndex + 1, high);

        return smallerElementIndex + 1; // Zwracamy indeks pivota
    }

    // Metoda do zamiany dwóch elementów w tablicy
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Metoda pomocnicza do sortowania pełnej tablicy
    public static void sort(int[] array) {
        if (array != null && array.length > 1) {
            sort(array, 0, array.length - 1);
        }
    }
}
