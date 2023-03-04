package com.akshet;

import java.util.Scanner;

public class LinearSearch {

    public void LSearch(int[] array, int target) {
        int count = 0;
        int ind = 0;
        int flag = 0;
        int[] index = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                flag = 1;
                count++;
                index[ind] = i;
                ind++;
            }
        }
        int count1=0;
        if (flag!=0) {
            System.out.print(target + " is present at ");
            for (int j : index) {
                count1++;
                if(count1>=count) {  //checking this condition to find the last occurrence of the element in the given array
                    //here we are doing i=i+1 to just show the position starts from 1
                    j=j+1;
                    System.out.print(j + "th ");
                    break;
                }
                //this is for any other occurrence other then the last one.
                // Similarly here we are doing i=i+1 to just show the position starts from 1
                    j = j + 1;
                    System.out.print(j + "th, ");
            }
            System.out.println("position i.e. total of " + count + " time/times.");
        }else{
            System.out.println("Element you want to find is not present in the given array! ");
        }
    }

    public static void main(String[] args){

        System.out.println("Enter the length of the array: ");
        Scanner scan= new Scanner(System.in);
        int size= scan.nextInt();

        System.out.println("Enter the elements of the array: ");
        int[] array = new int[size];
        // 23 45 1 2 8 19 -3 16 -11 28
        //45 2 8 19 -3 45 10 19 45 45
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }
        System.out.println("Entered array is:");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.println("]");

        System.out.println("Enter the element you want to find: ");
        int target= scan.nextInt();

        //Calling a non static method so making an object
        LinearSearch obj = new LinearSearch();

        obj.LSearch(array,target);

    }
}
