package com.learning;

import java.util.Scanner;

public class DrawLadder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(printStairCase(n));

    }

    private static String printStairCase(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                if(i+j<=n)   {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }

            }
            sb.append(System.lineSeparator());
        }
        return  sb.toString();
    }
}
