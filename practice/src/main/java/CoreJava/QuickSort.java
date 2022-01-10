package CoreJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuickSort {
    @Test
    public void test(){
//        int[] arr = {1,1,2};
//        sort(arr);
//        for(int i: arr){
//            System.out.println(i);
//        }
        int size = 100000;
        int[] arr1 = arrGen(size);

        int[] arr2 = arr1.clone();
        Assertions.assertArrayEquals(arr1, arr2);

        long s1 = System.nanoTime();
        sort(arr1);

        long e1 = System.nanoTime();
        long delayNS1 = e1-s1;
        long duration1 = TimeUnit.MILLISECONDS.convert(delayNS1, TimeUnit.NANOSECONDS);

        long s2 = System.nanoTime();
        Arrays.sort(arr2);
        long e2 = System.nanoTime();
        long delayNS2 = e2-s2;
        long duration2 = TimeUnit.MILLISECONDS.convert(delayNS2, TimeUnit.NANOSECONDS);

        Assertions.assertArrayEquals(arr1, arr2);

        System.out.println("My duratin:"+duration1);
        System.out.println("Java duratin:"+duration2);
    }

    public void sort(int[] nums){
        int end = nums.length-1;
        int start = 0 ;
        quickSort(start, end, nums);
    }

    public void quickSort(int start, int end, int[] nums){
        if(start == end )
            return;
        int pivot = nums[end];
        int L = start, R = end;
        while(true){
            while(R>=start && nums[R]>= pivot){
                R--;
            }

            while(nums[L]<pivot){
                L++;
            }
            if(L>=R){
                swap(L,end,nums);
                break;
            }
            swap(L,R,nums);
        }
        int newEnd = (L-1<start) ? start : L-1;
        int newStart = (L+1>end) ? end: L+1;
        quickSort(start,newEnd, nums);
        quickSort(newStart,end,nums);

    }

    public void swap(int index1, int index2, int[]nums){
        if(index1==index2)
            return;
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public int[] arrGen(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for(int i = 0; i< size;i++){
            arr[i] = r.nextInt(size);
        }
        return arr;
    }
}
