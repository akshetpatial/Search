package com.akshet;

import java.util.Arrays;
import java.util.Scanner;

public class Searchin2DSortedArray {

    public static int[] findTargetBinarySorted(int[][] array, int target) {

        // Here we have used the previous approach But we can further optimize it as the array is sorted so we can do some minor changes
        /*
        int row=array.length;
        int col=array[0].length;

        int start_row=0;
        int end_col=col-1;

    // Time complexity is O(N)

        while(start_row<row && end_col>=0){
            if(array[start_row][end_col]==target)
                return new int[] {start_row,end_col};
            else if(array[start_row][end_col]>target){
                end_col--;
            }
            else{
                start_row++;
            }
        }
*/

        // In this approach the time complexity will be log(N)


        int StartRow = 0;
        int EndCol = array[0].length - 1;
        int EndRow = array.length - 1;

        while (StartRow <= EndRow ) {
            if (array[StartRow][EndCol] == target)
                return new int[]{StartRow, EndRow};
            else if (array[StartRow][EndCol] > target) {
                int[] tempArray;
                tempArray = array[StartRow];
                int index = BSearch(tempArray, target);
                if (index == -1)
                    return new int[]{-1, -1};
                else
                    return new int[]{StartRow, index};
            } else
                StartRow++;
        }
        return new int[] {-1,-1};
    }

    public static int BSearch(int[] array,int target){
        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Enter the Row Size: ");
        Scanner scan = new Scanner(System.in);
        int row= scan.nextInt();

        System.out.println("Enter the Column Size");
        int col= scan.nextInt();

        int[][] TwoDArray= new int[row][col];

        System.out.println("Enter the elements of the 2D Array");

        //In this all the elements are sorted from start till the end

        // 1 2 3 4 5 6 7 8 9 10 11 12   0 1 2 3 4 5 6 7 8 9 10 11

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

        int[] find_1=findTargetBinarySorted(TwoDArray,target);

        System.out.println(Arrays.toString(find_1));
    }
}
