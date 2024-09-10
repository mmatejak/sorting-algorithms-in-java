package com.mtjk.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BucketSort {

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return; // Tablica z jednym lub żadnym elementem jest już posortowana
        }

        // Znalezienie wartości minimalnej i maksymalnej w tablicy
        int min = findMin(array);
        int max = findMax(array);

        // Inicjalizacja koszy
        int bucketCount = calculateBucketCount(array.length);
        List<List<Integer>> buckets = initializeBuckets(bucketCount);

        // Rozdzielanie elementów do koszy
        distributeElements(array, min, max, bucketCount, buckets);

        // Sortowanie elementów w każdym koszu
        sortBuckets(buckets);

        // Scalanie posortowanych koszy z powrotem do tablicy
        mergeBuckets(array, buckets);
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    private static int calculateBucketCount(int length) {
        return (int) Math.sqrt(length); // Propozycja dynamicznej liczby kubełków
    }

    private static List<List<Integer>> initializeBuckets(int bucketCount) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        return buckets;
    }

    private static void distributeElements(int[] array, int min, int max, int bucketCount, List<List<Integer>> buckets) {
        for (int num : array) {
            int bucketIndex = (max == min) ? 0 : (num - min) * (bucketCount - 1) / (max - min);
            buckets.get(bucketIndex).add(num);
        }
    }

    private static void sortBuckets(List<List<Integer>> buckets) {
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
    }

    private static void mergeBuckets(int[] array, List<List<Integer>> buckets) {
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }
}
