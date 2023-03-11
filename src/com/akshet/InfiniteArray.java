package com.akshet;

import java.util.Scanner;

public class InfiniteArray {

    public static int byLSearch(int[] array, int target){
        //Enter a chunk
        System.out.println("Find by using Linear Search!");
        int start=0;
        int end=1;
        while(start<=end) {
            int start1=start;
            int end1=end;
            int count=0;
            while (start1 <= end1) {
                if (array[start1] != target) {
                    start1++;
                    count++;
                }
                else{
                    return (start+count);
                }
            }
            int sizeofchunk=end-start;
            start=end+1;
            end=(sizeofchunk*2)+start;
            if(end>=array.length){
                return -1;
            }
        }
        return -1;
    }

    public static int byBSearch(int[] array, int target){
        //Enter a chunk
        System.out.println("Find by using Binary Search!");
        int start=0;
        int end=1;
        while(start<=end) {
            int start1=start;
            int end1=end;
            while (start1 <= end1) {
                int mid= start1 + (end1-start1)/2;
                if(array[mid]>target)
                    end1=mid-1;
                else if(array[mid]<target)
                    start1=mid+1;
                else{
                    return mid;
                }
            }
            int sizeofchunk=end-start;
            start=end+1;
            end=(sizeofchunk*2)+start;
            if(end>=array.length){
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println("Enter the array:");
        Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> array = new ArrayList<>();
        int[] array= new int[10];
        // 1 2 4 6 7 9 10 12 14 15
        for(int i=0;i<10;i++){
            array[i]=(scan.nextInt());
        }
        System.out.println("Enter the element you want to find! ");
        int target= scan.nextInt();
        //Find the target when the size of the array is not given
        //Find by Linear Search
       int pos= byLSearch(array, target);
       if(pos!=-1)
           System.out.println("the target "+ target+" has been found at the position "+pos+"th.");
       else
           System.out.println("the target "+ target+ " is not found");
        //Find by Binary Search

        int pos1 = byBSearch(array,target);
        if(pos1!=-1)
            System.out.println("the target "+ target+" has been found at the position "+pos+"th.");
        else
            System.out.println("the target "+ target+ " is not found");

    }
}
