package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertionSort {

    // Metoda sortowania tablicy przy użyciu algorytmu Insertion Sort
    public static void sort(int[] array) {
        int length = array.length;

        // Iteracja przez tablicę od drugiego elementu
        for (int i = 1; i < length; i++) {
            int key = array[i]; // Element do wstawienia
            int j = i - 1;

            // Przesuwanie elementów większych od key w prawo
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Wstawianie key na odpowiednie miejsce
            array[j + 1] = key;
        }
    }
}
