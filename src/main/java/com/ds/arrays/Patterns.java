package com.ds.arrays;

public class Patterns {

    // Print the Patterns. Follow the below steps to solve any pattern problems
   /**
    //  1. identify the num of rows. num of lines = num of rows = num times outer loop will run
        2. identify the num of columns for each row and types of elements in the each row
        3. what do u need to print
pattern 1:
    *
    * *
    * * *
    * * * *
pattern 2:
    * * * *
    * * *
    * *
    *
pattern3:
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *
 pattern4:
    1
    1 2
    1 2 3
    1 2 3 4
pattern5:
    *
    * *
    * * *
    * * * *
    * * * * *
    * * * *
    * * *
    * *
    *


    **/

   public static void main(String args[]){
       //patternc(4);
       pattern2(4);
   }



    private static void patternb(int n) {
        for( int i=1; i<=n+(n-1); i++)
        {
            for ( int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
            if(i==n){
                for(int j=n-1; j>=1;j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }

    private static void patterna(int n) {
        for (int rows = 0; rows <2*n; rows++) {

            int numofstars = rows>=n ? 2*n-rows: rows;
            int spaces = n-numofstars;
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }

            for ( int columns=0;columns<numofstars;columns++){
               // if (rows==n) {
                    if (columns==0 || columns==numofstars-1){
                        System.out.print("* ");
                    } else{
                        System.out.print("  ");
                    }
//                }
//                else {
//                    System.out.print("* ");
//                }
            }
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        for (int i = 0; i < 2*n; i++) {
                int  column= i>n? (2*n-i) : i;
            for (int j=0;j<column;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern1(int n) {
//       for (int rows=1;rows<=n;rows++){
//           for (int col=1;col<=rows;col++){
//               System.out.print(col+" ");
//           }
//           System.out.println();
//       }

        for (int row=1;row<=n;row++){
            for(int column=1;column<=row;column++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern2(int n){
//       for (int rows=0;rows<n;rows++){
//           for (int col=0;col<n-rows;col++){
//               System.out.print("* ");
//
//           }
//           // when one row is printed, we need to add a new line
//           System.out.println();
//       }
        for (int row=0;row<n;row++){
            for(int column=1;column<=n-row;column++){
                System.out.print("* ");
            }
            System.out.println();
        }

   }
    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
    }

    static void pattern4(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j + " ");

            }
            System.out.println();

        }
    }
}
