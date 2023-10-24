package com.problemSolving;

import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int arraySize = sc.nextInt();
            int desiredSum = sc.nextInt();
            int[] inputArr = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                inputArr[j] = sc.nextInt();
            }
            printResult(inputArr, desiredSum);

        }

    }

    private static void printResult(int[] inputArr, int desiredSum) {
        int arraySize = inputArr.length;
        //Arrays.sort(inputArr);
        boolean printed = false;
        for (int i = 0; i < arraySize; i++) {
            int sum = 0;
            for (int j = i; j < arraySize; j++) {
                sum += inputArr[j];
                if (sum == desiredSum) {
                    System.out.println((i + 1) + " " + (j + 1));
                    printed = true;
                    break;
                } else if (sum > desiredSum) {
                    break;
                }
            }
            if (printed) {
                break;
            }
        }
        if (!printed) {
            System.out.println(-1);
        }
    }
}
