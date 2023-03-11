package com.akshet;
//https://leetcode.com/problems/find-in-mountain-array/description/
import java.util.Scanner;

public class MountainArray {


    interface MountainArrayInterface{
      /*  All methods in an interface are implicitly public and abstract (but not final).
        All fields in an interface are implicitly public, static and final.
      */
        // Here if we add public or static it is redundant
        int get(int index);
        int length();
    }

    // Now after implementing the class as anonymous we do not need this Class anymore

    // implement the MountainArrayInterface interface
   /* static class MountainArrayClass implements MountainArrayInterface{

        int[] constArray;

      /*  This is the practical use of constructor
        Constructor in java is used to create the instance of the class.
         Constructors are almost similar to methods except for two things -
         1. its name is the same as the class name
         2. it has no return type.
         Sometimes constructors are also referred to as special methods to initialize an object. */


        /*
        There are three types of constructor in java.
        Default Constructor
        No-Args constructor
        Parameterized constructor

        public MountainArrayClass(int[] array) {
           this.constArray=array;
        }

    } */

    public static int findInMountainArrayLinear(int target, MountainArrayInterface mountainArr) {

        System.out.println("\n Using Linear Search:");
        int start_1=0;
        int end_1= mountainArr.length()-1;
        int ans_1=-1;
        //for start index
        while(start_1<=end_1){
            if(mountainArr.get(start_1)==target) {
                ans_1 = start_1;
                break;
            }
            else
                start_1++;
        }

        int start_2=0;
        int end_2=mountainArr.length()-1;
        int ans_2=-1;
        // for end index
        while(start_2<=end_2){
            if(mountainArr.get(end_2)==target) {
                ans_2 = end_2;
                break;
            }
            else
                end_2--;
        }

        if(ans_1>ans_2)
            return ans_2;
        else
            return ans_1;
    }

    public static int findInMountainArrayBinary(int target, MountainArrayInterface mountainArr) {

        System.out.println("\n Using Binary Search:");

        return BinarySearchforIndex(mountainArr,target);
    }

    public static int BinarySearchforIndex(MountainArrayInterface mountainArr, int target){

       int start=0;
       int end=mountainArr.length()-1;
       int mid;
        int PeakIndex=-1;
       while(start<=end){
           mid = start + (end-start)/2;
           if(mountainArr.get(mid)<mountainArr.get(mid+1)){
               start=mid+1;
           } else if(mountainArr.get(mid)>mountainArr.get(mid+1)) {
               end=mid;
           }
           if(start==end)
           {
               PeakIndex=start;
               break;
           }
       }

       // System.out.println("PeakIndex"+PeakIndex);
       int New_Start=0;
       int New_End=PeakIndex;
       int Old_End=mountainArr.length()-1;

       int Start_Index=-1;
       int End_Index=-1;
       int flag=0;

       while(New_Start<=New_End){
           int New_Mid= New_Start+(New_End-New_Start)/2;
           if(mountainArr.get(New_Mid)<target){
               New_Start=New_Mid+1;
           } else if(mountainArr.get(New_Mid)>target) {
               New_End=New_Mid-1;
           }else{
               flag++;
               Start_Index=New_Mid;
               break;
           }
       }

        System.out.println("Start_Index_1"+Start_Index);
        int New_Start_1=PeakIndex;

        while(New_Start_1<=Old_End){
            int New_Mid= New_Start_1+(Old_End-New_Start_1)/2;
            //Here the condition will be opposite as it is a decreasing Array
            if(mountainArr.get(New_Mid)>target){
                New_Start_1=New_Mid+1;
            } else if(mountainArr.get(New_Mid)<target) {
                Old_End=New_Mid-1;
            }else{
                flag++;
                End_Index=New_Mid;
                break;
            }
        }

//        System.out.println("End_Index"+End_Index);
//        System.out.println("Start_Index"+Start_Index);

        if(flag!=0) {
            if (Start_Index != -1 && End_Index != -1) {
                if (Start_Index > End_Index)
                    return End_Index;
                else
                    return Start_Index;
            } else if (Start_Index == -1 && End_Index != -1) {
                return End_Index;
            } else {
                return Start_Index;
            }
        }
        else
            return -1;

    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println("Enter the mountain array: ");
        int[] array=new int[size];
//      1 2 3 4 5 3 1    0 1 2 4 2 1
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Entered the mountain array is: ");
        System.out.print("[ ");
        for(int element : array){
            System.out.print(element+" ");
        }
        System.out.print("]");

        System.out.println("\nEnter the target element: ");
        int target = scan.nextInt();


        //Creating a constructor
        //Here the constructor is Parameterized constructor
        //MountainArrayClass MClass = new MountainArrayClass(array);


        // Here a good concept HOW TO PASS AN INTERFACE AS A PARAMETER so her we need to pass the body of the methods defined above
        // in the interface itself
        // Here we are implementing the interface as an anonymous inner class
        int index=findInMountainArrayLinear(target,new MountainArrayInterface(){
            // implementation of abstract method
            @Override
            public int get(int index) {
                return array[index];
            }

            // implementation of abstract method
            @Override
            public int length() {
                return array.length;
            }
        });

        System.out.println(index);

        int index1=findInMountainArrayBinary(target,new MountainArrayInterface(){
            // implementation of abstract method
            @Override
            public int get(int index) {
                return array[index];
            }

            // implementation of abstract method
            @Override
            public int length() {
                return array.length;
            }
        });
        System.out.println(index1);
    }
}
