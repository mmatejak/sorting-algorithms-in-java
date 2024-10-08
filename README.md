# Sorting Algorithms Project

## Opis

Ten projekt zawiera implementacje różnych algorytmów sortowania w języku Java. Każdy algorytm jest zaimplementowany w osobnej klasie i przetestowany w dedykowanej klasie testowej, co pozwala na łatwe porównanie ich działania i efektywności. W projekcie znajdują się następujące algorytmy sortowania:

1. [Bubble Sort](src/main/java/com/mtjk/algorithms/BubbleSort.java)
2. [Bucket Sort](src/main/java/com/mtjk/algorithms/BucketSort.java)
3. [Counting Sort](src/main/java/com/mtjk/algorithms/CountingSort.java)
4. [Heap Sort](src/main/java/com/mtjk/algorithms/HeapSort.java)
5. [Insertion Sort](src/main/java/com/mtjk/algorithms/InsertionSort.java)
6. [Merge Sort](src/main/java/com/mtjk/algorithms/MergeSort.java)
7. [Quick Sort](src/main/java/com/mtjk/algorithms/QuickSort.java)
8. [Radix Sort](src/main/java/com/mtjk/algorithms/RadixSort.java)
9. [Selection Sort](src/main/java/com/mtjk/algorithms/SelectionSort.java)

## Algorytmy

### 1. [Bubble Sort](src/main/java/com/mtjk/algorithms/BubbleSort.java)

Bubble Sort jest prostym algorytmem sortowania, który wielokrotnie przechodzi przez listę, porównuje sąsiadujące elementy i wymienia je, jeśli są w złej kolejności. Proces ten powtarza się, aż lista będzie posortowana.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n²)
    - Średni przypadek: O(n²)
    - Najlepszy przypadek: O(n) (gdy lista jest już posortowana)
- **Złożoność pamięciowa:** O(1) (sortowanie w miejscu)
- **Zalety:** Łatwy do implementacji, rozpoznaje już posortowaną listę.
- **Wady:** Bardzo wolny dla dużych zbiorów danych.

Testy dla Bubble Sort znajdują się w klasie [BubbleSortTest](src/test/java/com/mtjk/algorithms/BubbleSortTest.java).

### 2. [Bucket Sort](src/main/java/com/mtjk/algorithms/BucketSort.java)

Bucket Sort dzieli elementy do różnych "koszy" (bucketów) w zależności od ich wartości, a następnie sortuje elementy w każdym koszu indywidualnie. Na końcu elementy z wszystkich koszy są scalane w jedną listę.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n²)
    - Średni przypadek: O(n + k) (gdzie k to liczba kubełków)
    - Najlepszy przypadek: O(n + k)
- **Złożoność pamięciowa:** O(n + k)
- **Zalety:** Bardzo szybki, gdy elementy są równomiernie rozłożone.
- **Wady:** Niezbyt efektywny dla danych o dużym zakresie wartości, wymaga dużej ilości pamięci.

Testy dla Bucket Sort znajdują się w klasie [BucketSortTest](src/test/java/com/mtjk/algorithms/BucketSortTest.java).

### 3. [Counting Sort](src/main/java/com/mtjk/algorithms/CountingSort.java)

Counting Sort jest algorytmem sortowania, który liczy liczbę wystąpień każdego unikalnego elementu w tablicy, a następnie wykorzystuje te informacje do ustalenia pozycji każdego elementu w posortowanej tablicy.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n + k) (gdzie k to zakres możliwych wartości)
    - Średni przypadek: O(n + k)
    - Najlepszy przypadek: O(n + k)
- **Złożoność pamięciowa:** O(n + k)
- **Zalety:** Bardzo szybki dla danych o ograniczonym zakresie wartości, stabilny.
- **Wady:** Wymaga dużej ilości pamięci, nie nadaje się do sortowania danych o dużym zakresie wartości.

Testy dla Counting Sort znajdują się w klasie [CountingSortTest](src/test/java/com/mtjk/algorithms/CountingSortTest.java).

### 4. [Heap Sort](src/main/java/com/mtjk/algorithms/HeapSort.java)

Heap Sort wykorzystuje strukturę danych zwaną kopcem (heap). Najpierw buduje kopiec z tablicy, a następnie wielokrotnie wyciąga największy element z kopca, aby uzyskać posortowaną tablicę.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n log n)
    - Średni przypadek: O(n log n)
    - Najlepszy przypadek: O(n log n)
- **Złożoność pamięciowa:** O(1) (sortowanie w miejscu)
- **Zalety:** Gwarantowana złożoność O(n log n) niezależnie od danych wejściowych.
- **Wady:** Nie jest stabilny, zazwyczaj wolniejszy niż Quicksort w praktyce.

Testy dla Heap Sort znajdują się w klasie [HeapSortTest](src/test/java/com/mtjk/algorithms/HeapSortTest.java).

### 5. [Insertion Sort](src/main/java/com/mtjk/algorithms/InsertionSort.java)

Insertion Sort sortuje elementy poprzez wstawianie każdego elementu w odpowiednie miejsce w posortowanej części tablicy. Algorytm działa poprzez budowanie końcowej posortowanej tablicy jeden element na raz.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n²)
    - Średni przypadek: O(n²)
    - Najlepszy przypadek: O(n) (gdy lista jest już posortowana)
- **Złożoność pamięciowa:** O(1) (sortowanie w miejscu)
- **Zalety:** Bardzo efektywny dla małych list i częściowo posortowanych danych.
- **Wady:** Niewydajny dla dużych zbiorów danych.

Testy dla Insertion Sort znajdują się w klasie [InsertionSortTest](src/test/java/com/mtjk/algorithms/InsertionSortTest.java).

### 6. [Merge Sort](src/main/java/com/mtjk/algorithms/MergeSort.java)

Merge Sort jest algorytmem sortowania typu "dziel i zwyciężaj". Dzieli tablicę na mniejsze podtablice, sortuje je indywidualnie, a następnie scala posortowane podtablice w jedną posortowaną tablicę.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n log n)
    - Średni przypadek: O(n log n)
    - Najlepszy przypadek: O(n log n)
- **Złożoność pamięciowa:** O(n) (potrzebuje dodatkowej pamięci na scalanie)
- **Zalety:** Stabilny, niezależny od kolejności danych wejściowych.
- **Wady:** Wymaga dodatkowej pamięci, wolniejszy dla małych zbiorów danych w porównaniu do Quicksort.

Testy dla Merge Sort znajdują się w klasie [MergeSortTest](src/test/java/com/mtjk/algorithms/MergeSortTest.java).

### 7. [Quick Sort](src/main/java/com/mtjk/algorithms/QuickSort.java)

Quick Sort jest kolejnym algorytmem typu "dziel i zwyciężaj". Wybiera element (pivot), dzieli tablicę na dwie części: elementy mniejsze i większe od pivota, a następnie sortuje każdą z tych części rekurencyjnie.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n²) (gdy pivot jest najgorszym możliwym wyborem, np. zawsze największy lub najmniejszy element)
    - Średni przypadek: O(n log n)
    - Najlepszy przypadek: O(n log n)
- **Złożoność pamięciowa:** O(log n) (dla wersji rekurencyjnej)
- **Zalety:** Bardzo szybki dla dużych zbiorów danych, z reguły wydajniejszy niż sortowanie bąbelkowe, przez wstawianie lub przez wybieranie.
- **Wady:** Może wymagać dużej ilości pamięci w przypadku złego wyboru pivota, ma przypadki degeneracyjne (np. już posortowana lista).

Testy dla Quick Sort znajdują się w klasie [QuickSortTest](src/test/java/com/mtjk/algorithms/QuickSortTest.java).

### 8. [Radix Sort](src/main/java/com/mtjk/algorithms/RadixSort.java)

Radix Sort sortuje liczby według poszczególnych cyfr, zaczynając od najmniej znaczącej. Używa algorytmu sortowania stabilnego (np. Counting Sort) do sortowania cyfr na każdym etapie.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(nk) (gdzie k to liczba cyfr w największym elemencie)
    - Średni przypadek: O(nk)
    - Najlepszy przypadek: O(nk)
- **Złożoność pamięciowa:** O(n + k)
- **Zalety:** Bardzo szybki dla liczb lub innych typów danych o stałej długości.
- **Wady:** Wymaga stabilnego algorytmu sortowania dla wewnętrznych sortowań (np. Counting Sort), nie nadaje się do danych o dużym zakresie wartości, wymaga dużej ilości pamięci.

Testy dla Radix Sort znajdują się w klasie [RadixSortTest](src/test/java/com/mtjk/algorithms/RadixSortTest.java).

### 9. [Selection Sort](src/main/java/com/mtjk/algorithms/SelectionSort.java)

Selection Sort sortuje tablicę poprzez wielokrotne znajdowanie minimalnego (lub maksymalnego) elementu z niezorganizowanej części tablicy i przenoszenie go na odpowiednie miejsce w posortowanej części tablicy.

- **Złożoność czasowa:**
    - Najgorszy przypadek: O(n²)
    - Średni przypadek: O(n²)
    - Najlepszy przypadek: O(n²)
- **Złożoność pamięciowa:** O(1) (sortowanie w miejscu)
- **Zalety:** Prostota implementacji, mała liczba zamian.
- **Wady:** Niewydajny dla dużych zbiorów danych.

Testy dla Selection Sort znajdują się w klasie [SelectionSortTest](src/test/java/com/mtjk/algorithms/SelectionSortTest.java).
