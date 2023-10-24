package com.ds.arrays;

import java.util.Arrays;

public class KSmallestElementsInArray {

    public static void main(String[] args) {
        printKSmallestElementsInArray(new int[]{6,3,89,18,90,45,2},3);
        System.out.println();
        printKSmallestElementsInArrayWithO1ExtraSpace(new int[]{6,3,89,18,90,45,2},3);
    }

    private  static void printKSmallestElementsInArray(int[] arr,int k) {

        int len = arr.length;

        int[] arrCopy = Arrays.copyOf(arr,len);

        Arrays.sort(arrCopy);

        for(int x:arr) {
           // System.out.println(Arrays.binarySearch(arrCopy,0,k,x));
           if(Arrays.binarySearch(arrCopy,0,k,x)>-1 ){
               System.out.print(x + " ");
           }
        }
    }

    private  static void printKSmallestElementsInArrayWithO1ExtraSpace(int[] arr,int k) {

        int len = arr.length;

        for(int i=k;i<len;i++) {

            //find max element in arr[0..k-1]
            int maxK = arr[k-1];
            int pos = k-1;
            for(int j=k-2; j>=0;j--) {
               if(maxK < arr[j]) {
                   maxK = arr[j];
                   pos=j;
               }
            }

            if(arr[i]<maxK) {
                int j= pos;
                while(j<k-1) {
                    arr[j]=arr[j+1];
                    j++;
                }
                arr[k-1]=arr[i];
            }
        }

        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }



}
