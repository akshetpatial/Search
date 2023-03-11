package com.akshet;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/

import java.util.Scanner;

public class PeakIndexofMountain {

    public static int PeakIndex(int[] array){
        System.out.println("\nUsing Linear Search!  ");
        int i=0;
        while(i<=array.length){
            if(i==array.length-1){
                return i;
            }else
            {
                if(array[i]<=array[i+1]){
                    i++;
                }else{
                    return i;
                }
            }
        }
        return array.length-1;
    }

    public static int PeakIndexBinary(int[] array){
        System.out.println("Using Binary Search!  ");
        int i=0;
        int start=0;
        int mid=0;
        int end=array.length-1;
        while(start<=end) {
           mid = start + (end - start) / 2;

            if (mid == start) {
                if(array[mid]>array[mid+1])
                    return mid;
                else
                    return mid+1;
            }else if(mid==end){
                if(array[mid]>array[mid-1])
                    return mid;
                else
                    return mid-1;
            }  else {
                if (array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
                    return mid;
                else if (array[mid] >= array[mid - 1] && !(array[mid] >= array[mid + 1]))
                    start = mid + 1;
                else if (array[mid] <= array[mid - 1] && array[mid] >= array[mid + 1])
                    end = mid - 1;
            }
        }
        return mid;
    }

    public static int PeakIndexBinary_1(int[] array){
        System.out.println("Using Binary Search second Approach!  ");
        int i=0;
        int start=0;
        int mid=0;
        int end=array.length-1;
        while(start<=end) {
            mid = start + (end - start) / 2;
            if (start == end)
                return start;
            if (array[mid] > array[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return mid;
    }


    public static void  main(String[] args){

        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the mountain array: ");
        int[] array=new int[size];
//      0 1 0,  0 2 1 0,  0 10 5 2
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered the mountain array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        int index=PeakIndex(array);

        System.out.println(index);

        System.out.println(PeakIndexBinary(array));

        System.out.println(PeakIndexBinary_1(array));
    }
}
