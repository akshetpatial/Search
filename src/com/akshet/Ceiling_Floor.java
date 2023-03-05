package com.akshet;

import java.util.Scanner;


public class Ceiling_Floor {

    public static int CeilingSearch(int[] array, int target){
        int start=0;
        int end= array.length-1;
        int mid;
        int pos=0;
        if(array[array.length-1]<target){
            System.out.println("No Ceil function can be found as target is greater than the last number");
            return -1;
        }
        else {
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (target == array[mid]) {
                    pos = mid;
                    return array[pos];
                } else if (target > array[mid]) {
                    start = mid + 1;
                    pos = mid + 1;
                } else if (target < array[mid]) {
                    end = mid - 1;
                }
            }
            return array[pos];
        }
    }

    public static int FloorSearch(int[] array, int target){
        int start=0;
        int end= array.length-1;
        int mid;
        int pos=0;
        if(array[0]>target){
            System.out.println("No Floor function can be found as target is less than the firt number");
            return -1;
        }
        else {
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (target == array[mid]) {
                    pos = mid;
                    return array[pos];
                } else if (target > array[mid]) {
                    start = mid + 1;
                } else if (target < array[mid]) {
                    end = mid - 1;
                    pos = mid - 1;
                }
            }
            return array[pos];
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the non repeating elements of sorted array: ");
        int[] array=new int[size];
//      2 4 6 9 11 12 14 20 36 48
//      48 36 20 14 12 11 9 6 4 2
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered non repeating element sorted array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        System.out.println("\nEnter the target you want to find: ");
        int target= scan.nextInt();


        int index= CeilingSearch(array,target);
        System.out.println("The output of Ceil Function is: "+index);
        int index1= FloorSearch(array,target);
        System.out.println("The output of floor Function is: "+index1);
    }
}
