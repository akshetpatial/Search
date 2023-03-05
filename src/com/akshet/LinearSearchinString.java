package com.akshet;

import java.util.Scanner;

public class LinearSearchinString {

    public static void SearchChar(String input, char target) {
        System.out.println("Entered String is: "+input);
        int i=0;
        int count=0;
        int flag=0;
        int ind=0;
        int[] index=new int[input.length()];
        while(i<input.length()){
            if(input.charAt(i)==target){
                count++;
                flag++;
                index[ind]=i;
            }
            i++;
        }

        int count1=0;
        if(flag!=0){
        System.out.print(target+" is present at the ");
        for(int element : index){
            count1++;
            if(count1>=count) {
                System.out.print(element + "th ");
                break;
            }
                System.out.print(element+"th, ");
        }
        System.out.println("position i.e. total of " + count + " time/times.");
    }else{
        System.out.println("Character you want to find is not present in the given String! ");
    }
    }

    public static void main(String[] args) {

        System.out.println("Enter the String: ");
        Scanner scan = new Scanner(System.in);
        String input= scan.nextLine();
        System.out.println("Enter the character you want to search in the input String: ");
        //Here we are taking a String at taking the char at index 0 a way og getting the char from the input
        char target= scan.nextLine().charAt(0);

        SearchChar(input,target);
    }

}
