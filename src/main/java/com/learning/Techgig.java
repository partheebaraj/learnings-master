package com.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Techgig {

    public static  void main(String args[]) {

        //System.out.println("Hi");

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        List<Long> villainStrengths = null;
        List<Long> playersEnergy = null;
        int numberOfPlayers =0;

        for(int i=0;i<numberOfTestCases;i++) {

            numberOfPlayers = scanner.nextInt();
            villainStrengths = new ArrayList<>(numberOfPlayers);

            for(int j=0;j<numberOfPlayers;j++) {
                villainStrengths.add(scanner.nextLong());
            }

            playersEnergy = new ArrayList<>(numberOfPlayers);
            for(int k=0;k<numberOfPlayers;k++) {

                playersEnergy.add(scanner.nextLong());

            }
            Collections.sort(villainStrengths);
            Collections.sort(playersEnergy);

            int counter =0;
            for(int l=0;l<numberOfPlayers;l++) {
                if(playersEnergy.get(l).compareTo(villainStrengths.get(l))<=0) {
                    System.out.println("LOSE");
                    break;
                }
                counter++;
            }
            if(numberOfPlayers == counter) {
                System.out.println("WIN");
            }
        }



    }
}
