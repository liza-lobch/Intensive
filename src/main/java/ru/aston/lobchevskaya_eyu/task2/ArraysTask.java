package ru.aston.lobchevskaya_eyu.task2;

import java.util.Random;

public class ArraysTask {

    // 1. Напишите программу, которая проверяет отсортирован ли массив по возрастанию. Если он отсортирован по возрастанию, то выводится “OK”, если нет, то будет выводиться текст “Please, try again”
    public static String isArrayAscSorted(int[] array) {
        boolean isArrayAscSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                isArrayAscSorted = false;
                break;
            }
        }
        return isArrayAscSorted ? "OK" : "Please, try again";
    }

    // 2. Напишите метод, который меняет местами первый и последний элемент массива
    public static void swapFirstAndLastArrayElements(int[] array) {
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    // 3. Дан массив чисел. Найдите первое уникальное в этом массиве число. Например, для массива [1, 2, 3, 1, 2, 4] это число 3
    public static Integer findFirstUniqueArrayElement(int[] array) {
        Integer uniqueElement = null;
        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueElement = array[i];
                break;
            }
        }
        return uniqueElement;
    }

    // 4. Заполните массив случайным числами и отсортируйте его. Используйте сортировку слиянием.
    public static void fillArrayWithRandomElements(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int middle = array.length / 2;
        int[] leftPart = new int[middle];
        int[] rightPart = new int[array.length - middle];

        for (int i = 0; i < middle; i++) {
            leftPart[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            rightPart[i - middle] = array[i];
        }

        mergeSort(leftPart);
        mergeSort(rightPart);

        merge(array, leftPart, rightPart);
    }

    private static void merge(int[] array, int[] leftPart, int[] rightPart) {
        int i = 0, j = 0, k = 0;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                array[k++] = leftPart[i++];
            } else {
                array[k++] = rightPart[j++];
            }
        }

        while (i < leftPart.length) {
            array[k++] = leftPart[i++];
        }

        while (j < rightPart.length) {
            array[k++] = rightPart[j++];
        }
    }
}