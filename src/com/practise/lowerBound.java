package com.practise;

import java.util.Scanner;

public class lowerBound {

    public static int lowerBound(int []arr, int n, int x) {
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = end + (start-end)/2;
//            System.out.println("start"+start);
//            System.out.println("end"+end);
//            System.out.println("mid"+mid);
            if(mid == 0)
                return mid;
            // if(mid == end)
            //     return mid+1;
            if(start==n-1)
                return n;
            if(start==end)
                return start;
            if(arr[mid] <x){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return 0;
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
        System.out.println("\nEnter the lower bound target");
        int x = scan.nextInt();
        int ans = lowerBound(arr,n,x);
        System.out.println(ans);
    }
}
