package com.abdullamzini.Tests;

import com.abdullamzini.MarsRoverMover;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;

public class MarsRoverMoverTest {

    private MarsRoverMover mrm;

    @BeforeMethod
    public void setup() {
        mrm = new MarsRoverMover("5 5", "1 2 N", "LMLMLMLMM");
    }

    @Test
    public void testMarsRoverMover_ReturnCorrectWith12N() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm.startMoveCmd();

        assertEquals("1 3 N\n", outContent.toString());
    }

    @Test
    public void testMarsRoverMover_ReturnCorrectResultsWith51E() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "3 3 E", "MMRMMRMRRM");
        mrm.startMoveCmd();

        assertEquals("5 1 E\n", outContent.toString());
    }

    @Test
    public void testMarsRoverMover_DoesNotMove_WithInvalidDirection() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "3 3 Z", "MMRMMRMRRM");
        mrm.startMoveCmd();
        assertEquals("3 3 Z\n", outContent.toString());
    }

    @Test
    public void testMarsRoverMover_WithWrongCmd() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "3 3 E", "MMPRMMRMRRM");
        mrm.startMoveCmd();
        assertEquals("Wrong type of input, please use either M, L or R\n" +
                "5 1 E\n", outContent.toString());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyFirstInput() throws Exception {
        mrm = new MarsRoverMover("", "3 3 E", "MMRMMRMRRM");
        mrm.startMoveCmd();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyStartingPos() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "", "MMRMMRMRRM");
        mrm.startMoveCmd();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMarsRoverMover_ThrowNullPointer_WithEmptyMoveCmd() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "3 3 E", "");
        mrm.startMoveCmd();
    }

    @Test(expectedExceptions = Exception.class)
    public void testMarsRoverMover_ThrowException_WithOutOfBounds() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mrm = new MarsRoverMover("5 5", "5 5 E", "MMRMMRMRRM");
        mrm.startMoveCmd();
    }

}
