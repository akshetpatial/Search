package com.akshet;

import java.util.Arrays;
import java.util.Scanner;

public class Searchin2DArray {

    public static int findTargetLinear(int[][] TwoDArray, int target){
        System.out.println("Using Linear Search!");
        int index=-1;

        for(int i=0;i<TwoDArray.length;i++){
            for(int j=0;j<TwoDArray[0].length;j++){
                if(target==TwoDArray[i][j])
                    index=(i*10)+j;
            }
        }
        return index;
    }

   // public static int findTargetBinary(int[][] TwoDArray, int target){
   public static int[] findTargetBinary(int[][] TwoDArray, int target){
        System.out.println("Using Linear Search!");
        int row=TwoDArray.length;
        int col=TwoDArray[0].length;
        int end = row*col;

        System.out.println("row length: "+row);
        System.out.println("col length: "+col);
        System.out.println("number of elements: "+end);

        int start_Row=0;
        int start_col=col-1;
        while(start_Row<=row-1 && start_col>=0){
            if(TwoDArray[start_Row][start_col]==target)
              return new int[] {start_Row,start_col};
            else if(TwoDArray[start_Row][start_col]>target)
                start_col--;
            else
                start_Row++;
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        System.out.println("Enter the Row Size: ");
        Scanner scan = new Scanner(System.in);
        int row= scan.nextInt();

        System.out.println("Enter the Column Size");
        int col= scan.nextInt();

        int[][] TwoDArray= new int[row][col];

        System.out.println("Enter the elements of the 2D Array");
        // 1 2 3 4 5 6 7 8 9   0 1 2 3 4 5 6 7 8 9 10 11
        // Test Data for Binary Search
        /*  10 20 30 40
            12 25 35 45
            28 29 37 49
            33 34 38 50 */

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                TwoDArray[i][j]=scan.nextInt();
            }
        }

        System.out.println("Entered 2DArray is: ");
        for(int[] element : TwoDArray){
            System.out.println(Arrays.toString(element));
        }

        System.out.println("Enter the element you want to find: ");
        int target= scan.nextInt();

        int find = findTargetLinear(TwoDArray,target);

        if(find!=-1) {
            int rem=find%10;
            find/=10;
            System.out.println("We have found the target element i.e. " + target + " ,its present at the position: ");
            System.out.println("Row: "+find+" Col: "+rem);
        }
        else{
            System.out.println("We did not find the target element ");
        }


        int[] find_1=findTargetBinary(TwoDArray,target);

        System.out.println(Arrays.toString(find_1));
        //We can also return the array of the elements
/*
        int find_1 = findTargetBinary(TwoDArray,target);

        if(find_1!=-1) {
            int rem=find_1%10;
            find_1/=10;
            System.out.println("We have found the target element i.e. " + target + " ,its present at the position: ");
            System.out.println("Row: "+find_1+" Col: "+rem);
        }
        else{
            System.out.println("We did not find the target element ");
        }
*/

    }
}
