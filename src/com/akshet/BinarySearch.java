package com.akshet;

import java.util.Scanner;

//why Binary Search is used ad in the worst case the time complexity is Big O of log2N
// N/2^k =1 assuming the kth level is the last level so we will have only one element left in the array.
// N= 2^k , N is the size of the array and k is the level or the number of comparisons made at each level.
// Log(N) = Log(2^K) => Log(N) = kLog(2) => k= Log(N)/Log(2)
// k = log2(N), Log base 2 of N where as for Linear Search the worst case time complexity is Big O of N;

public class BinarySearch {

    public static void BSearch(int[] array, int target){
        int start=0;
        int end= array.length-1;
        int mid;
        int pos=0;
        //This check is for ascending sorted array
        if(array[0]<=array[array.length-1]) {
            while (start <= end) {
                // here below in some cases start + end may exceed the max range of the int so it may give you some error
                //so the better way of doing this can be
               // mid = (start + end) / 2;   Commented out the unoptimised way
               mid = start + (end - start )/2;  //Better way
                if (target == array[mid]) {
                    pos = mid;
                    break;
                } else if (target > array[mid]) {
                    start = mid + 1;
                } else if (target < array[mid]) {
                    end = mid - 1;
                }
            }
        }
        //This check is for descending sorted array
        else{
            while (start <= end) {
                mid = (start + end) / 2;
                if (target == array[mid]) {
                    pos = mid;
                    break;
                } else if (target < array[mid]) {
                    start = mid + 1;
                } else if (target > array[mid]) {
                    end = mid - 1;
                }
            }
        }
        if(start>end)
            System.out.println("The target element is not found in the given array!");
        else
            System.out.println(target +" is found at the "+(pos+1)+"th position.");

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

        BSearch(array,target);
    }
}
