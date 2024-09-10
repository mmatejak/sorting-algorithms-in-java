package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CountingSort {

    // Metoda sortowania tablicy przy użyciu algorytmu Counting Sort
    public static void sort(int[] array) {
        if (array.length <= 1) {
            return; // Tablica z jednym lub żadnym elementem jest już posortowana
        }

        // Znalezienie wartości minimalnej i maksymalnej w tablicy
        int min = findMin(array);
        int max = findMax(array);

        // Inicjalizacja tablicy do zliczania
        int range = max - min + 1;
        if (range <= 0) return; // Obsługuje przypadek, gdy min == max

        int[] count = new int[range];

        // Zliczanie wystąpień każdego elementu
        countOccurrences(array, min, count);

        // Aktualizacja tablicy wejściowej z posortowanymi elementami
        updateArray(array, count, min);
    }

    // Znajdowanie minimalnej wartości w tablicy
    private static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    // Znajdowanie maksymalnej wartości w tablicy
    private static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    // Zliczanie wystąpień każdego elementu
    private static void countOccurrences(int[] array, int min, int[] count) {
        for (int num : array) {
            count[num - min]++;
        }
    }

    // Aktualizacja tablicy wejściowej z posortowanymi elementami
    private static void updateArray(int[] array, int[] count, int min) {
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i + min;
                count[i]--;
            }
        }
    }
}
