package com.learning;

import java.util.*;
import java.util.stream.Collectors;

public class TicketNumber{
    public static void main(String args[] ) throws Exception {

        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for(int i=0;i<numberOfTestCases;i++) {

            int numberOfPlayers = scanner.nextInt();
            List<Ticket>  ticketNumbers = new ArrayList<>(numberOfPlayers);

            for (int j = 0; j < numberOfPlayers; j++) {
                ticketNumbers.add(new Ticket(scanner.nextInt(),j));
            }
            printTicketNumber(ticketNumbers);
        }

        System.out.println(System.currentTimeMillis()-startTime);

    }
    private static void printTicketNumber(List<Ticket>  ticketNumbers) {
        int numOfPlayers= ticketNumbers.size();
        if(numOfPlayers==0 || (ticketNumbers.size()==1 && ticketNumbers.get(0).getValue()==0)) {
            System.out.println(" ");
            return;
        } else if(numOfPlayers==1) {
            System.out.println(ticketNumbers.get(0).getValue());
            return;
        } else if(numOfPlayers==2) {
            System.out.println(ticketNumbers.stream()
                    .map(e->e.getValue()).max(Comparator.naturalOrder()).get());
            return;
        }

        List<Ticket> finalTicketNumbers =ticketNumbers.stream()
                .sorted(Comparator.comparing(Ticket::getValue).thenComparing(Ticket::getPosition))
                .collect(Collectors.toList());



        Ticket first = finalTicketNumbers.get(numOfPlayers-1);
        Ticket second = finalTicketNumbers.get(numOfPlayers-2);
        Ticket third = finalTicketNumbers.get(numOfPlayers-3);
        int maxTicketNumber = first.getValue();


        String result = "";
        int iResult =0;

        if(isNeighbours(first,second,numOfPlayers)) {
            result = getResultString(first,second);
            iResult = first.getValue() + second.getValue();
        } else if(isNeighbours(first,third,numOfPlayers)) {
            result = getResultString(first,third);
            iResult = first.getValue() + third.getValue();
        } else if(isNeighbours(second,third,numOfPlayers)) {
            result = getResultString(second,third);
            iResult = second.getValue() + third.getValue();
        }

        result = iResult > maxTicketNumber ? result : String.valueOf(maxTicketNumber);
        System.out.println(result);
    }

    private static boolean isNeighbours(Ticket ticket1,Ticket ticket2,int numOfPlayers) {

        return ((ticket1.getPosition()-1 != ticket2.getPosition()) &&
                (ticket1.getPosition()+1 != ticket2.getPosition()))
               /* && !(ticket1.getPosition()==0 && ticket2.getPosition()==numOfPlayers-1)
                && !(ticket2.getPosition()==0 && ticket1.getPosition()==numOfPlayers-1)*/;

    }

    private static String getResultString(Ticket ticket1,Ticket ticket2) {

        return  ticket1.getPosition() > ticket2.getPosition() ? ticket1.getValue()+""+ticket2.getValue()
                : ticket2.getValue()+""+ticket1.getValue();
    }
}

class Ticket {
    private int value;
    private int position;

    public Ticket(int value, int position) {
        this.value =value;
        this.position = position;

    }

    public int getValue() {
        return this.value;
    }

    public int getPosition() {
        return this.position;
    }
}