package com.akshet;
//https://leetcode.com/problems/search-in-rotated-sorted-array/

import java.util.Scanner;

public class RotatedSortedArray {

    // We can also do the same by recursion
    public static int RotatedArray(int[] array, int target){
       int index= pivotPoint(array);
        System.out.println("Index: "+index);
       int start;
       int end;
            if(array[index]==target)
                return index;
            else{
               start= BSearch(array,target,true,index);
               end = BSearch(array,target,false,index);
            }
            if(start!=-1)
                return start;
            else if(end!=-1)
                return end;
        return -1;
    }

    public static int BSearch(int[] array, int target,boolean check, int index){
        if(check && index!=0){
            int start=0;
            int end= index-1;
            while(start<=end){
                int mid= start+ (end-start)/2;
                if(array[mid]==target)
                    return mid;
                else if(array[mid]>target)
                    end= mid-1;
                else
                    start=mid+1;
            }
        }else if(!check && index!=array.length-1){
            // here this is important or else some cases are going to fail for EX [3,1] target 1 will give -1 when
            // We chose start=index only
            int start=index+1;
            int end= array.length-1;
            while(start<=end){
                int mid= start+ (end-start)/2;
                if(array[mid]==target)
                    return mid;
                else if(array[mid]>target)
                    end= mid-1;
                else
                    start=mid+1;
            }
        }
        return -1;
    }

    // This method will not work for duplicated values We need to make some changes to handle the duplicate values numbers
    // This is just very important to find as this is the point where two arrays can be divided
    public static int pivotPoint(int[] array){
        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid= start+ (end-start)/2;
            if(start==mid) {
               if(array[start]>array[end])
                   return start;
               else
                   return end;
            }
            if(array[mid]<array[mid-1])
                return mid-1;
            else if(array[mid]>array[mid+1])
                return mid;
            /* commenting the code as it will give wrong answer for duplicate values
            else if(array[start]>array[mid])
                end=mid-1;
            else if(array[start]<=array[mid])
                start=mid;
                */
            //adding some more conditions to check the duplicate values
            // So we are removing duplicates
                if (array[start] == array[mid] && array[end]==array[mid]) {
                    if(array[start]>array[start+1])
                        return start;
                    else if(array[end]<array[end-1])
                        return end-1;
                    start++;
                    end--;
                }
                //No again checking similar conditions commented onwards line no 74
                else if(array[start]<array[mid] || (array[start]==array[mid] && array[mid] > array[end]))
                    start=mid;
                else
                    end = mid-1;
        }
        return array.length-1;
    }

    public static int CountOFRotatedArray(int[] array){

        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(start==mid) {
                if(array[start]>array[end])
                    return start;
                else
                    return -1;
            }
            if(array[mid]>array[mid+1])
                return mid;
            if(array[mid]<array[mid-1])
                return mid-1;
            if(array[start]>array[mid])
                end =mid-1;
            if(array[mid]>array[start])
                start=mid;
        }

        return -1;
    }

    public static void main(String[] args){

        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the Rotated array: ");
        int[] array=new int[size];
//      4 5 6 7 0 1 2 3   5 1 3
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered the Rotated array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        System.out.println("\nEnter the target element: ");
        int target = scan.nextInt();

        int index= RotatedArray(array,target);
        System.out.println(index);

        int count = CountOFRotatedArray(array);
        System.out.println("Count of Rotated array is: "+ (count+1));

    }
}
