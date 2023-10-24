package com.ds.arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        mergeTwoSortedArrays(new int[]{2,5,6,9,31},
                             new int[]{1,7,11,35});

        mergeTwoSortedArraysWithOrder1ExtraSpace(new int[]{2,5,6,9,31},
                new int[]{1,7,11,35});
    }
//1,2,5,6,31
    //9,7,11,35
    private static void mergeTwoSortedArrays(int[] arr1,int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1+len2;
        int[] result = new int[len];
        int i=0,j=0,k=0;

        while(i<len1 && j<len2) {
            if(arr1[i]<arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<len1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j<len2) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        for(int x: result){
            System.out.println(x);
        }
    }

    private static void mergeTwoSortedArraysWithOrder1ExtraSpace(int[] arr1,int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

       for(int j=len2-1;j>=0;j--) {
           int temp = arr1[len1-1];
           int i;
           for(i=len1-2;i>=0&&arr1[i]>arr2[j];i--) {
              arr1[i+1] = arr1[i];
           }

           if(i!=len1-2 || temp >arr2[j]) {
               arr1[i+1] = arr2[j];
               arr2[j] = temp;
           }
       }

        for(int x: arr1){
            System.out.println(x);
        }

        for(int x: arr2){
            System.out.println(x);
        }
    }



}
