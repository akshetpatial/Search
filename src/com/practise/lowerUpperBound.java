package com.practise;

import java.util.Scanner;

public class lowerUpperBound {

    public static int lowerBound(int []arr, int n, int x) {
        int start = 0;
        int end = n-1;
        int mid =0;
        while(start<=end){
            mid = start + (end - start) / 2;
            if(mid == 0)
                return mid;
            // if(mid == end)
            //     return mid+1;
            if(start==n-1)
                return n;
            if(start==end)
                return start;
            if(arr[mid] <x){
                System.out.println("here x greater");
                start = mid+1;
            }else{
                System.out.println("here x lesser");
                end = mid;
            }
        }
        return 0;
    }

    public static int upperBound(int []arr, int n, int x) {
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = start + (end -start)/2;
            if(start==n-1)
                return n;
            if(start==end)
                return end;
            // if(mid == n-1)
            //     return n;
            // if(end==mid)
            //     return mid;
            if(arr[mid] > x)
                end = mid;
            else
                start = mid+1;
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println("Enter the length of the array: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Enter the Elements of the array: ");
        int[] arr = new int[n];
        for(int i =0;i<n;i++)
            arr[i]=scan.nextInt();
        System.out.println("Entered array: ");
        for(int ele : arr)
            System.out.print(ele+" ");
//        System.out.println("\nEnter the lower bound target");
        System.out.println("\nEnter the Upper bound target");
        int x = scan.nextInt();
//        int ans = lowerBound(arr,n,x);
        int ans = upperBound(arr,n,x);
        System.out.println(ans);
    }
}
