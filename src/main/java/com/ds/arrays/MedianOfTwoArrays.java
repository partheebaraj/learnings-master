package com.ds.arrays;

import java.util.Scanner;

public class MedianOfTwoArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input First Array Size");
        int firstArraySize = scanner.nextInt();
        System.out.println("Input First Array Elements");
        int[] inputArray1 = new int[firstArraySize];
        for(int i=0;i<firstArraySize;i++) {
            inputArray1[i] = scanner.nextInt();
        }
        System.out.println("Input Second Array Size");
        int secondArraySize = scanner.nextInt();
        System.out.println("Input Second Array Elements");
        int[] inputArray2 = new int[secondArraySize];
        for(int i=0;i<secondArraySize;i++) {
            inputArray2[i] = scanner.nextInt();
        }

        //System.out.println(medianOfTwoArrays(inputArray1,inputArray2));
        System.out.println(medianOfTwoArraysInLogTime(inputArray1,inputArray2));
    }

    private static double medianOfTwoArraysInLogTime(int[] inputArray1,int[] inputArray2) {

     if(inputArray1.length>inputArray2.length) {
         return medianOfTwoArrays(inputArray2,inputArray1);
     }
     int X = inputArray1.length;
     int Y = inputArray2.length;
     int low =0;
     int high = X;

      while (low<=high){
         int partitionX = (low+high)/2;
         int partitionY = (X+Y+1)/2-partitionX;

         int maxLeftX = partitionX==0 ? Integer.MAX_VALUE : inputArray1[partitionX-1];
         int minRightX = partitionX==X ? Integer.MAX_VALUE : inputArray1[partitionX];

         int maxLeftY = partitionY==0 ? Integer.MIN_VALUE : inputArray2[partitionY-1];
         int minRightY = partitionY==Y ? Integer.MAX_VALUE : inputArray2[partitionY];

         if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
            //return median
             if((X+Y)%2==0) {
                     return (double) (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
             } else {
                 return (double) Math.max(maxLeftX, maxLeftY);
             }
         } else if(maxLeftX > minRightY) {
             high = partitionX-1;
         } else {
             low = partitionX+1;
         }
     }
     throw new IllegalArgumentException();
    }

    private static int medianOfTwoArrays(int[] inputArray1,int[] inputArray2) {
        int tempArrayLength =inputArray1.length+inputArray2.length;
        int[] tempArray = new int[tempArrayLength];
        int i=0,j=0,k=0;
        while(i<inputArray1.length && j<inputArray2.length) {
            if(inputArray1[i]<=inputArray2[j]) {
                tempArray[k] = inputArray1[i];
                i++;

            } else {
                tempArray[k] = inputArray2[j];
                j++;
            }
            k++;
        }

        while(i<inputArray1.length) {
            tempArray[k] = inputArray1[i];
            i++;
            k++;
        }
        while(j<inputArray1.length) {
            tempArray[k] = inputArray1[j];
            j++;
            k++;
        }

        int mid =tempArrayLength/2;
        if(tempArrayLength%2!=0) {
            return tempArray[mid];
        }
        return (tempArray[mid]+tempArray[mid-1])/2;
    }

}
