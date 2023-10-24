package com.ds;

public class LongestCommonSubSequence {


    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("ABCDGH","AEDFHR"));
    }

    private static int  longestCommonSubSequence(String str1,String str2) {

        int m =str1.length()+1;
        int n= str2.length()+1;
        int[][] arr = new int[m][n];

       // initializeArray(arr,m,n);
        printArray(arr,m,n);

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0) {
                    arr[i][j]=0;
                }
                else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        System.out.println("result");
        printArray(arr,m,n);

        printLongestSequence(arr,str1,str2);

        return arr[m-1][n-1];
    }

    private static void printLongestSequence(int[][] arr,String str1,String str2){
        StringBuilder sb = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while( i>0 && j>0) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    sb.append(str1.charAt(i-1));
                    i=i-1;
                    j=j-1;
                } else if(arr[i-1][j]>arr[i][j-1]) {
                    i=i-1;
                } else {
                    j=j-1;
                }
            }


        System.out.println(sb.toString());


    }

    /*private static void initializeArray(int[][] arr, int length1,int length2) {

        for(int i=0;i<length2;i++) {
           arr[0][i]=0;
        }
        for(int j=0;j<length1;j++) {
            arr[j][0]=0;
        }
    }*/

    private static void printArray(int[][] arr,int m,int n) {
       for(int i=0;i<m;i++) {
           for(int j=0;j<n;j++) {
               System.out.print(arr[i][j]);
           }
           System.out.println();
       }
    }

}



