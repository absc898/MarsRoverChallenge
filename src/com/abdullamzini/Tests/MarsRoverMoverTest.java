package com.abdullamzini.Tests;

import com.abdullamzini.MarsRoverEntity;
import com.abdullamzini.MarsRoverMover;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class MarsRoverMoverTest {

    static final String MAX_BOUNDS = "5 5";
    static final String START_POS1 = "1 2 N";
    static final String MOVE_CMD1 = "LMLMLMLMM";
    static final String START_POS2 = "3 3 E";
    static final String MOVE_CMD2 = "MMRMMRMRRM";
    private MarsRoverMover mrm;
    private MarsRoverEntity mr1;
    private MarsRoverEntity mr2;
    List<MarsRoverEntity> marsRovers = new ArrayList<>();

    @BeforeMethod
    public void setup() {
        mr1 = new MarsRoverEntity(MAX_BOUNDS, START_POS1, MOVE_CMD1);
        mr2 = new MarsRoverEntity(MAX_BOUNDS, START_POS2, MOVE_CMD2);
        marsRovers.add(mr1);
        marsRovers.add(mr2);
        mrm = new MarsRoverMover(marsRovers);
    }

    @AfterMethod
    public void cleanUp() {
        marsRovers = new ArrayList<>();
    }

    @Test
    public void testMarsRoverMover_ReturnCorrectOutputForMultipleRovers() {
        ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent2));

        mrm.printOutputs();

        assertEquals("1 3 N\n5 1 E\n", outContent2.toString());
    }

    @Test
    public void testMarsRoverMover_DoesNotMove_WithInvalidDirection() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("5 5", "3 3 Z", "MMRMMRMRRM");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);
        mrm.printOutputs();

        assertEquals("3 3 Z\n", outContent.toString());
    }

    @Test
    public void testMarsRoverMover_WrongInputMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("5 5", "3 3 E", "MMPRMMRMRRM");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);
        mrm.printOutputs();

        assertEquals("Wrong type of input, please use either M, L or R\n" +
                "5 1 E\n", outContent.toString());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyFirstInput() {
        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("", "3 3 E", "MMRMMRMRRM");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyStartingPos() {
        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("5 5", "", "MMRMMRMRRM");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyMoveCmd() {
        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("5 5", "3 3 E", "");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);
    }

    @Test
    public void testMarsRoverMover_WithOutOfBoundsError() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MarsRoverEntity nonMovingMrm = new MarsRoverEntity("5 5", "5 5 E", "MMRMMRMRRM");
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        marsRoversTest.add(nonMovingMrm);
        mrm = new MarsRoverMover(marsRoversTest);

        assertEquals("Error has occurred, accessing out of bounds, please stay in between 0, 0 and 5 5\n",
                outContent.toString());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_WithEmptyRoversList() {
        List<MarsRoverEntity> marsRoversTest = new ArrayList<>();
        mrm = new MarsRoverMover(marsRoversTest);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_WithNullRoversList() {
        mrm = new MarsRoverMover(null);
    }

}
