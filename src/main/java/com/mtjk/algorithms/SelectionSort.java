package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SelectionSort {

    // Metoda sortowania tablicy za pomocą algorytmu Selection Sort
    public static void sort(int[] array) {
        int length = array.length;

        // Przechodzenie przez wszystkie elementy tablicy
        for (int i = 0; i < length - 1; i++) {
            // Zakładamy, że bieżący element jest najmniejszy
            int smallestIndex = i;

            // Znalezienie indeksu najmniejszego elementu w nieposortowanej części tablicy
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;  // Aktualizacja indeksu najmniejszego elementu
                }
            }

            // Zamiana elementów, jeśli znaleziono mniejszy element
            if (smallestIndex != i) {
                int temp = array[smallestIndex];
                array[smallestIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
