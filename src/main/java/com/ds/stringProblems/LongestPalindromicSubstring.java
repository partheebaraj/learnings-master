package com.ds.stringProblems;

import java.sql.SQLOutput;

public class LongestPalindromicSubstring {
    static int resultStart;
    static int resultLength;
    public static void main(String[] args) {
       longestPalindromicSubstring("madamji");
       System.out.print( alternateApproah("forgeeksskeegfor"));
    }

    private static String alternateApproah(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() &&
                str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }


    public static int longestPalindromicSubstring(String str) {

        int n = str.length();
        int[][] arr = new int[n][n];
        int maxLength=1;

        for(int i=0;i<n;i++) {
            arr[i][i]=1;
        }

        int start=0;

        for(int i=0;i<n-1;i++) {

            if(str.charAt(i)==str.charAt(i+1)) {
                arr[i][i+1]= 1;
                start =i;
                maxLength =2;
            }
        }

        for(int k=3;k<=n;k++) {

            for(int i=0;i<n-k+1;i++) {

                int j=i+k-1;
                if(arr[i+1][j-1]==1 && str.charAt(i)==str.charAt(j)) {
                   arr[i][j]=1;
                   if(k>maxLength) {
                       start = i;
                       maxLength = k;
                   }
                }

            }

        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }


    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
}
