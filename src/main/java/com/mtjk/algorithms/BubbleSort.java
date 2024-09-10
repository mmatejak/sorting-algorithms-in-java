package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BubbleSort {

    // Metoda sortowania tablicy przy użyciu algorytmu Bubble Sort
    public static void sort(int[] array) {
        int length = array.length;
        boolean swapped;

        // Kontynuujemy sortowanie, dopóki będą wykonywane zamiany
        do {
            swapped = false;
            // Przechodzimy przez tablicę, porównując sąsiednie elementy
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    // Zamieniamy elementy miejscami, jeśli są w złej kolejności
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true; // Ustawiamy flagę, aby zaznaczyć, że wykonano zamianę
                }
            }
            // Skracamy zakres o 1, ponieważ ostatni element jest już na właściwej pozycji
            length--;
        } while (swapped); // Kontynuujemy, jeśli wykonano zamianę
    }
}
