package ru.aston.lobchevskaya_eyu.task2;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class ArraysTaskTest {

    @Test
    public void isArrayAscSortedTest() {
        int[] array1 = new int[]{1, 2, 5, 6, 7};
        int[] array2 = new int[]{1, 6, 5, 6, 7};

        Assert.assertEquals("OK", ArraysTask.isArrayAscSorted(array1));
        Assert.assertEquals("Please, try again", ArraysTask.isArrayAscSorted(array2));
    }

    @Test
    public void swapFirstAndLastArrayElementsTest() {
        int[] array1 = new int[]{5, 6, 7, 2};
        ArraysTask.swapFirstAndLastArrayElements(array1);

        Assert.assertEquals(2, array1[0]);
        Assert.assertEquals(5, array1[array1.length - 1]);
    }

    @Test
    public void findFirstUniqueArrayElementTest() {
        int[] array1 = new int[]{1, 2, 3, 1, 2, 4};
        int[] array2 = new int[]{1, 2, 3, 1, 2, 3};

        Assert.assertEquals((Integer)3, ArraysTask.findFirstUniqueArrayElement(array1));
        Assert.assertNull(ArraysTask.findFirstUniqueArrayElement(array2));
    }

    @Test
    public void mergeSortTest() {
        int[] array1 = new int[10];
        ArraysTask.fillArrayWithRandomElements(array1);
        int[] array2 = array1.clone();

        ArraysTask.mergeSort(array1);
        Arrays.sort(array2);

        Assert.assertArrayEquals(array2, array1);
    }
}