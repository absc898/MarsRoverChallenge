package com.abdullamzini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String MAX_BOUNDS = "";
    static String START_POS1 = "";
    static String MOVE_CMD1 = "";
    static String START_POS2 = "";
    static String MOVE_CMD2 = "";

    public static void main(String[] args) throws IOException {
        readInput();
        List<MarsRoverEntity> marsRovers = new ArrayList<>();
        MarsRoverEntity mr1 = new MarsRoverEntity(MAX_BOUNDS, START_POS1, MOVE_CMD1);
        MarsRoverEntity mr2 = new MarsRoverEntity(MAX_BOUNDS, START_POS2, MOVE_CMD2);
        marsRovers.add(mr1);
        marsRovers.add(mr2);
        MarsRoverMover mrm = new MarsRoverMover(marsRovers);
        mrm.printOutputs();
    }

    public static void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Please enter a max bounds (space separated):");
        MAX_BOUNDS = reader.readLine();

        System.out.println("Enter rover one starting position:");
        START_POS1 = reader.readLine();

        System.out.println("Enter rover one move commands:");
        MOVE_CMD1 = reader.readLine();

        System.out.println("Enter rover two starting position:");
        START_POS2 = reader.readLine();

        System.out.println("Enter rover two move commands:");
        MOVE_CMD2 = reader.readLine();
    }
}
