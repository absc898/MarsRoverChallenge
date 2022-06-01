package com.abdullamzini;

public class Main {

    static final String MAX_BOUNDS = "5 5";
    static final String START_POS1 = "1 2 N";
    static final String MOVE_CMD1 = "LMLMLMLMM";
    static final String START_POS2 = "3 3 E";
    static final String MOVE_CMD2 = "MMRMMRMRRM";

    public static void main(String[] args) {
        try {
            MarsRoverMover mrm = new MarsRoverMover(MAX_BOUNDS, START_POS1, MOVE_CMD1);
            mrm.startMoveCmd();
            mrm = new MarsRoverMover(MAX_BOUNDS, START_POS2, MOVE_CMD2);
            mrm.startMoveCmd();
        } catch (Exception e){
            System.out.println("Something bad happened");
        }

    }
}
