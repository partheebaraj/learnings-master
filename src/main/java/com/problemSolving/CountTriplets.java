package com.problemSolving;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CountTriplets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int arraySize = sc.nextInt();
            int[] inputArr = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                inputArr[j] = sc.nextInt();
            }
            printNumberOfTriplets(inputArr);

        }


    }

    private static void printNumberOfTriplets(int[] inputArr) {
        Arrays.sort(inputArr);
        int length = inputArr.length;
        int max = inputArr[length-1];
        int numberOfTriplets = 0;
        Set<Integer> set = Arrays.stream(inputArr).boxed().collect(Collectors.toSet());

       // List is significantly slower for search compared to Set. Set improves search performance from  >2.2 seconds to 0.7 seconds
       // List<Integer> set = Arrays.stream(inputArr).boxed().collect(Collectors.toList());


        for(int i=0;i<length;i++) {
          for(int j=i+1;j<length;j++) {
              int sum = inputArr[i]+inputArr[j];
              if(sum >max) {
                  continue;
              } else {
                  if(set.contains(sum)) {
                      //System.out.println((inputArr[i]+","+inputArr[j]+","+sum));
                      numberOfTriplets++;
                  }
              }
          }
      }
        if(numberOfTriplets > 0) {
            System.out.println(numberOfTriplets);
        } else {
            System.out.println(-1);
        }
    }
}
