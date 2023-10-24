package com.learning;

import java.util.*;

public class TGPB2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for(int i=0;i<numberOfTestCases;i++) {

            int numberOfPlayers = scanner.nextInt();
            List<Long> ticketNumbers = new ArrayList<>(numberOfPlayers);

            for (int j = 0; j < numberOfPlayers; j++) {
                ticketNumbers.add(scanner.nextLong());
            }
            printTicketNumber(ticketNumbers);
        }



    }

    private static void printTicketNumber(List<Long> ticketNumbers) {

        if(ticketNumbers.size()==0) {
            System.out.println(" ");
            return;
        }
        if(ticketNumbers.size()==1) {
            System.out.println(ticketNumbers.get(0));
            return;
        }
        if(ticketNumbers.size()==2) {
            System.out.println(ticketNumbers.stream().max(Comparator.naturalOrder()).get());
            return;
        }

        Long excludingSum = 0L;
        LinkedList<Long> sbExcludingCurrent = new LinkedList<>();

        Long includingSum = ticketNumbers.get(0);
        LinkedList<Long> sbIncludingCurrent = new LinkedList<>();
        sbIncludingCurrent.add(ticketNumbers.get(0));
        ticketNumbers.remove(ticketNumbers.get(0));

        for (Long current: ticketNumbers) {
            Long newIncludingSum;

            LinkedList<Long> sbNewIncludingCurrent;

            if(current >= excludingSum ) {
                sbNewIncludingCurrent = new LinkedList<>();
                sbNewIncludingCurrent.add(current);
                newIncludingSum = current;
            } else {
                sbNewIncludingCurrent = new LinkedList<>(sbExcludingCurrent);
                newIncludingSum = excludingSum;
            }

            if((excludingSum+current) > newIncludingSum) {
                sbNewIncludingCurrent = new LinkedList<>(sbExcludingCurrent);
                sbNewIncludingCurrent.add(current);
                newIncludingSum = excludingSum+current;
            }

            if(includingSum > newIncludingSum) {

                sbNewIncludingCurrent = new LinkedList<>(sbIncludingCurrent);
                newIncludingSum = includingSum;
            }

            sbExcludingCurrent = sbIncludingCurrent;
            sbIncludingCurrent = sbNewIncludingCurrent;

            excludingSum =includingSum;
            includingSum =newIncludingSum;


        }

        if(includingSum > excludingSum) {
            printResult(sbIncludingCurrent);
        } else {
            printResult(sbExcludingCurrent);

        }


    }


    private static void printResult(LinkedList<Long> sb){

        if(sb.size()==1) {
            System.out.println(sb.get(0));
        }  else {
            Collections.reverse(sb);
            sb.forEach(System.out::print);
            System.out.print("\n");
        }
    }

}


