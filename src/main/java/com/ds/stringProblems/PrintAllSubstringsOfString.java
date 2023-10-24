package com.ds.stringProblems;

public class PrintAllSubstringsOfString {

    public static void main(String[] args) {
        //printAllSubstringsOfString("abcd");
        System.out.println(isPalindrome("geeksskeeg"));

    }


    public static void printAllSubstringsOfString(String str) {

        int len = str.length();
        for(int i=0;i<len;i++) {

            for(int j=i;j<len;j++) {
                //System.out.println(str.substring(i,j+1));
                //System.out.println(Arrays.copyOfRange(str.toCharArray(),i,j+1));
                copyOfRange(str.toCharArray(),i,j+1);


            }

        }

    }

    public static void copyOfRange(char[] charArr,int startPos,int endPos) {
        int len = endPos - startPos;
        //char[] copyArr = new char[len];

        for(int i=startPos;i<endPos;i++) {
            System.out.println(charArr[i]);
        }

    }

    public static boolean isPalindrome(String str) {
       int i=0;
       int j=str.length()-1;
       while (i<j) {
           if(str.charAt(i)!=str.charAt(j)) {
               return false;
           }
           i++;
           j--;
       }
       return true;
    }
}
