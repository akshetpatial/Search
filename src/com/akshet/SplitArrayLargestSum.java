package com.akshet;
//https://leetcode.com/problems/split-array-largest-sum/

import java.util.Arrays;
import java.util.Scanner;

public class SplitArrayLargestSum {

    public static int MinMaxSum(int[] array, int target){
        int sum=0;
        int max=array[0];
        //Finding the Maximum element in the array
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            if(max<array[i])
                max=array[i];
        }
        int start=max;
        int end=sum;
        System.out.println("Start: "+start+  " End: "+end);

        while(start<=end){
            int ArraySum=0;
            int mid=start+(end-start)/2;
            int pieces=1;
            for(int i=0;i<array.length;i++){
                ArraySum+=array[i];
                if(ArraySum>mid) {
                    i--;
                    pieces++;
                    ArraySum=0;
                }
            }
            if(pieces>target){
                start=mid+1;
            }
            else{
                end=mid;
            }
            if(start==mid)
                return mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the Array: ");
        int[] array=new int[size];
//      7 2 5 10 8
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered Array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        System.out.println("\nEnter the number to Split the Array in SubArrays: ");
        int target = scan.nextInt();

        int max_sum= MinMaxSum(array,target);
        System.out.println(max_sum);


    }
}
