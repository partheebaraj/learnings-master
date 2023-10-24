package com.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {



    public static void main(String[] args) {

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);
        threadPoolExecutor.submit(ThreadPoolExecutorTest::test);
        System.out.println("done");

    }

    private static void test() {
        for(int i=0;i<5000;i++) {

            System.out.println("HI");

        }
        System.out.println("child thread done");
    }



}
