package com.aleclewald;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        generateTeams(30, 5);

    }

    public static ArrayList<Integer> generateNumbers(int noOfEntrants) {
        ArrayList<Integer> wrestlers = new ArrayList<Integer>();

        for (int i=0; i<noOfEntrants; i++) {
            wrestlers.add(i);
        }
        Collections.shuffle(wrestlers);
        return wrestlers;
    }

    public static ArrayList<String> generatePlayers (int noOfTeams) {
        ArrayList<String> players = new ArrayList<String>();
        String name = "";
        for (int i=0; i<noOfTeams; i++) {
            boolean holder = true;
            while (holder) {
                name = scanner.nextLine();
                if (players.contains(name)) {
                    System.out.println("Name already entered, pick a new one");
                } else {
                    holder = false;
                }
            }
            players.add(name);
        }
        Collections.shuffle(players);
        return players;
    }

    public static void generateTeams(int noOfEntrants, int noOfTeams) {
        ArrayList<Integer> rumble = generateNumbers(noOfEntrants);
        ArrayList<String> players = generatePlayers(noOfTeams);
        int teamSize = rumble.size() / noOfTeams;
        int currentPosition = 0;
        for (int i=0; i<noOfTeams; i++){
            System.out.println(players.get(i) + " has the following entrants:");
            System.out.println();
            for (int j=0; j<teamSize; j++) {
                System.out.println("Entrant number: " + (rumble.get(currentPosition)+1));
                currentPosition++;
            }
            System.out.println("=========================================");
        }
        if (currentPosition < rumble.size()) {
            System.out.println("Rando's Entrants: ");
            for (int k=currentPosition; k<rumble.size(); k++) {
                System.out.println("Entrant number: " + (rumble.get(k) + 1));
            }
        }
    }
}
