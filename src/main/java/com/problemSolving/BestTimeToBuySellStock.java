package com.problemSolving;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        System.out.println(bestTimeToBuySellStock(new Long[]{7L,1L,5L,3L,6L,4L}));
        System.out.println(bestTimeToBuySellStock(new Long[]{7L,6L,4L,3L,1L}));
        System.out.println(bestTimeToBuySellStock(new Long[]{1L,2L,3L,4L,5L}));
        System.out.println(bestTimeToBuySellStock(new Long[]{1L,2L,3L,4L,5L,2L,6L,7L,8L,11L}));


    }

    private static Long bestTimeToBuySellStock(Long[] priceMovements) {
        if(priceMovements.length ==0 || priceMovements.length==1) {
            return 0L;
        }

        Long max = priceMovements[0];
        Long min = priceMovements[0];
        Long maxProfit = 0L;
        Long currentProfit = 0L;

        for (int i=1;i<priceMovements.length;i++){
             if(priceMovements[i] < min) {
                 min = priceMovements[i];
                 max = priceMovements[i];
             }
            if(priceMovements[i] > max) {
                max = priceMovements[i];
            }
            currentProfit = max - min;
            if(currentProfit>maxProfit) {
                maxProfit =currentProfit;
            }
        }
        if(currentProfit>maxProfit) {
            maxProfit =currentProfit;
        }

        return maxProfit.longValue();
    }
}
