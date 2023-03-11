package com.akshet;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
import java.util.Arrays;
import java.util.Scanner;

public class FirstandLastindex {

    public static int[] FlIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] temp = {0, 0};
        int f = 0;
        int l = 0;
        while (start <= end) {
            if (nums[start] != target)
                start++;
            else {
                f = start;
                break;
            }
        }
        while (start <= end) {
            if (nums[end] != target)
                end--;
            else {
                l = end;
                break;
            }
        }
        temp[0] = f;
        temp[1] = l;
        return temp;
    }

    public static int[] FlIndexBinary(int[] nums, int target) {

        int start= BSearchreturnindex(nums,target,true);
        int end = BSearchreturnindex(nums,target,false);
       int[] temp =new int[2];
       temp[0]=start;
       temp[1]=end;
       return temp;
    }

    public static int BSearchreturnindex(int[] nums, int target, boolean firstIndex) {
        int index=-1;
        int start = 0;
        int end = nums.length-1;
        //boolean Firstcheck=false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else {
                index=mid;
                    if(firstIndex){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
            }
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the non repeating elements of sorted array: ");
        int[] array=new int[size];
//      5 7 7 7 7 8 8 10
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered non repeating element sorted array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        System.out.println("\nEnter the target you want to find of its first and last occurrence: ");
        int target= scan.nextInt();

        int[] index= FlIndex(array,target);
        int[] index1=FlIndexBinary(array, target);

        System.out.println("Using Linear Search\nThe index is: "+ Arrays.toString(index));
        System.out.println("Using Binary Search\nThe index is: "+ Arrays.toString(index1));
    }
}
