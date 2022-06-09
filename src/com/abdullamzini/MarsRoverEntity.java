package com.abdullamzini;

public class MarsRoverEntity {
    private String maxBounds;
    private String startingPos;
    private String moveCmd;

    public MarsRoverEntity(String maxBounds, String startingPos, String moveCmd) {
        this.maxBounds = maxBounds;
        this.startingPos = startingPos;
        this.moveCmd = moveCmd;
    }

    public String getMaxBounds() {
        return maxBounds;
    }

    public String getStartingPos() {
        return startingPos;
    }

    public String getMoveCmd() {
        return moveCmd;
    }
}
