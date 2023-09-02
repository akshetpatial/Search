package com.practise;

import java.util.Scanner;

public class lowerBound {

    public static int lowerBound(int []arr, int n, int x) {
        
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
            System.out.println(ele+" ");
        System.out.println("Enter the lower bound target");
        int x = scan.nextInt();
        int ans = lowerBound(arr,n,x);
        System.out.println(ans);
    }
}
