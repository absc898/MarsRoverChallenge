package com.abdullamzini;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverMover {

    List<Integer> maxPos = new ArrayList<Integer>();
    private int x_pos = 0;
    private int y_pos = 0;
    private String currentDirection = "N";
    private String moveCmd = "";

    public MarsRoverMover(String maxBounds, String startingPos, String moveCmd) {

        if(maxBounds.isEmpty() || startingPos.isEmpty() || moveCmd.isEmpty()) {
            throw new NullPointerException("One of the inputs passed is empty, please review and try again");
        }

        //Grab the max x and y pos
        for(Character c : maxBounds.toCharArray()) {
            if(!Character.isWhitespace(c)) {
                maxPos.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        //Grab the current pos
        int counter = 0;
        for(Character p : startingPos.toCharArray()) {
            if(!Character.isWhitespace(p)) {
                if(counter < 1) {
                    counter++;
                    this.x_pos = Integer.parseInt(String.valueOf(p));
                } else if (counter == 1) {
                    counter++;
                    this.y_pos = Integer.parseInt(String.valueOf(p));
                } else {
                    currentDirection = String.valueOf(p);
                }
            }
        }

        this.moveCmd = moveCmd;
    }

    public void startMoveCmd() throws Exception {

        for(Character m : moveCmd.toCharArray()) {
            switch (m) {
                case 'M':
                    moveForward();
                    break;
                case 'L':
                    changeDirectionLeft();
                    break;
                case 'R':
                    changeDirectionRight();
                    break;
                default:
                    System.out.println("Wrong type of input, please use either M, L or R");
            }
            checkIfOutOfBounds();
        }
        System.out.println(this.x_pos + " " + this.y_pos + " " + this.currentDirection);
    }

    private void moveForward() {
        switch (this.currentDirection) {
            case "N":
                this.y_pos++;
                break;
            case "S":
                this.y_pos--;
                break;
            case "E":
                this.x_pos++;
                break;
            case "W":
                this.x_pos--;
                break;
            default:
                break;
        }
    }

    private void changeDirectionLeft() {
        switch (this.currentDirection) {
            case "N":
                this.currentDirection = "W";
                break;
            case "S":
                this.currentDirection = "E";
                break;
            case "E":
                this.currentDirection = "N";
                break;
            case "W":
                this.currentDirection = "S";
                break;
            default:
                break;
        }
    }

    private void changeDirectionRight() {
        switch (this.currentDirection) {
            case "N":
                this.currentDirection = "E";
                break;
            case "S":
                this.currentDirection = "W";
                break;
            case "E":
                this.currentDirection = "S";
                break;
            case "W":
                this.currentDirection = "N";
                break;
            default:
                break;
        }
    }

    private void checkIfOutOfBounds() throws Exception {
        if(this.x_pos < 0 || this.x_pos > maxPos.get(0)|| this.y_pos < 0 || this.y_pos > maxPos.get(1)) {
            throw new Exception("Error, accessing out of bounds, please stay in between 0, 0 and " +
                    maxPos.get(0).toString() + " " + maxPos.get(1).toString());
        }
    }

}
