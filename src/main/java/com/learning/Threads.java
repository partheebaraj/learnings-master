package com.learning;

import java.util.concurrent.ForkJoinPool;

public class Threads {


    public static  void main(String args[]) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool());

    }
}
