package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HeapSort {

    // Metoda sortowania tablicy przy użyciu algorytmu Heap Sort
    public static void sort(int[] array) {
        int length = array.length;

        // Budowanie maksymalnego kopca (heap)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Usuwanie elementów z kopca jeden po jednym i umieszczanie ich na końcu tablicy
        for (int i = length - 1; i > 0; i--) {
            // Przenoszenie korzenia (największy element) na koniec tablicy
            swap(array, 0, i);

            // Wywołanie funkcji heapify na zmniejszonym kopcu
            heapify(array, i, 0);
        }
    }

    // Funkcja do przekształcania tablicy w kopiec (heap)
    private static void heapify(int[] array, int length, int index) {
        int largest = index; // Inicjalizacja największego jako korzeń
        int leftChild = 2 * index + 1; // Lewe dziecko
        int rightChild = 2 * index + 2; // Prawe dziecko

        // Sprawdzanie, czy lewe dziecko jest większe od korzenia
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Sprawdzanie, czy prawe dziecko jest większe od największego
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Jeśli największy nie jest korzeniem, zamieniamy je i wywołujemy heapify rekurencyjnie
        if (largest != index) {
            swap(array, index, largest);

            heapify(array, length, largest);
        }
    }

    // Funkcja do zamiany dwóch elementów w tablicy
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
