package com.mtjk.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void testEmptyArray() {
        int[] array = {};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{}, array, "Tablica powinna pozostać pusta po sortowaniu.");
    }

    @Test
    void testSingleElementArray() {
        int[] array = {5};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{5}, array, "Tablica z jednym elementem powinna pozostać niezmieniona.");
    }

    @Test
    void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array, "Tablica już posortowana powinna pozostać niezmieniona.");
    }

    @Test
    void testReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array, "Tablica posortowana w odwrotnej kolejności powinna być posortowana rosnąco.");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, array, "Tablica z duplikatami powinna być posortowana.");
    }

    @Test
    void testArrayWithAllSameValues() {
        int[] array = {7, 7, 7, 7, 7};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, array, "Tablica z identycznymi wartościami powinna pozostać niezmieniona.");
    }

    @Test
    void testArrayWithNegativeValues() {
        int[] array = {-5, -1, -10, 0, 3, 2};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{-10, -5, -1, 0, 2, 3}, array, "Tablica z wartościami ujemnymi powinna być posortowana rosnąco.");
    }

    @Test
    void testArrayWithMixedValues() {
        int[] array = {3, -2, 7, 4, 1, -5};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{-5, -2, 1, 3, 4, 7}, array, "Tablica z mieszanką wartości dodatnich i ujemnych powinna być posortowana rosnąco.");
    }
}