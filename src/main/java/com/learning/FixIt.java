package com.learning;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FixIt {
    private static final SimpleDateFormat sdfTemporalDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
    private static final SimpleDateFormat sdfForDate = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {


        BuyerStatus buyerStatus = BuyerStatus.BLACKLISTED;
        if(BuyerStatus.ACTIVE.ordinal()<(buyerStatus.ordinal())) {
            System.out.println("working");
        }

     //System.out.println(getSellerOrderNo("00092404","00092404_1"));

    }

    public static String getTransactionDate(String strDate) {
        try {
            Date date =  sdfTemporalDate.parse(strDate);
            System.out.println(date);
            return sdfForDate.format(date);
        } catch (ParseException pe) {
            throw  new RuntimeException("unable to parse the date");
        }
    }

    public static BigDecimal getShare(BigDecimal bAmount,BigDecimal balanceTotal,BigDecimal collectedAmount) {
        return bAmount.multiply(collectedAmount)
                .divide(balanceTotal, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static String getSellerOrderNo(String buyerOrderNo,String sellerOrderNo) {
        return buyerOrderNo+"/"+sellerOrderNo.substring(sellerOrderNo.length()-3);
    }
}
