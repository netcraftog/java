package CoreJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyMergeSort {

    @Test
    public void mergeSortTest() {
        int size = 1000000;
        int[] arr1 = arrGen(size);
        int[] arr2 = arr1.clone();
        Assertions.assertArrayEquals(arr1, arr2);

        long s1 = System.nanoTime();
        sort(arr1);
        long e1 = System.nanoTime();
        long delayNS1 = e1 - s1;
        long duration1 = TimeUnit.MILLISECONDS.convert(delayNS1, TimeUnit.NANOSECONDS);

        long s2 = System.nanoTime();
        Arrays.sort(arr2);
        long e2 = System.nanoTime();
        long delayNS2 = e2 - s2;
        long duration2 = TimeUnit.MILLISECONDS.convert(delayNS2, TimeUnit.NANOSECONDS);

        Assertions.assertArrayEquals(arr1, arr2);

        System.out.println("My duratin:" + duration1);
        System.out.println("Java duratin:" + duration2);
    }

    public int[] arrGen(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(size);
        }
        return arr;
    }

    public void sort(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        int[] cache = new int[nums.length];
        mergeSort(start, end, nums, cache);
    }

    public void mergeSort(int start, int end, int[] nums, int[] cache) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid, nums, cache);
        mergeSort(mid + 1, end, nums, cache);

        merge(start, mid, mid + 1, end, nums, cache);
    }

    public void merge(int start1, int end1, int start2, int end2, int[] nums, int[] cache) {
        int pointer1 = start1;
        int pointer2 = start2;
        int pointerCache = start1;

        while (pointerCache <= end2) {
            if (nums[pointer1] < nums[pointer2]) {
                cache[pointerCache] = nums[pointer1];
                pointer1++;
                if (pointer1 > end1) {
                    copy(pointer2, end2, end2, nums, cache);
                    break;
                }
            } else {
                cache[pointerCache] = nums[pointer2];
                pointer2++;
                if (pointer2 > end2) {
                    copy(pointer1, end1, end2, nums, cache);
                    break;
                }
            }
            pointerCache++;

        }
        copy(start1, end2, end2, cache, nums);
    }

    public void copy(int start, int end, int arrEnd, int[] arr, int[] target) {
        for (int i = arrEnd, j = end; j >= start; i--, j--) {
            target[i] = arr[j];
        }
    }
}
