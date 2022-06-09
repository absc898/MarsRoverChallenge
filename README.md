The program will return the expected output as stated in the challenge.
My attempted was to keep the code simply and in separate functions as possible. As you can see the MarsRoverMover class will first in the contractor take the inputs passed and place them into the correct variables such as getting the max bounds and its current direction.

Then the startMoveCmd() when called will start moving the rover based on its position and move commands. Depending on which move operation we receive (M, L, R), it will call a function that will handle the move. The idea here was split each move into separate cases to increase readability and making it easier to test. At this stage, if we get a command that is not what we expected, we will just simply log a message rather than throwing and continue to process the remaining commands (unit tested).

We will only throw in the following cases:
- One of the inputs is empty
- The rovers move to a position that is out of bounds

The above cases have been united tested. We check after each operation ran, to see if we are out of bounds or not before we continue within our for loop in startMoveCmd().

Finally, only the startMoveCmd() is exposed on the class, making all other function private. This helps make the code more usable as it is simply to the user what they should call. The main idea for this, is making unit testing easier, as we are testing the entire approach for each valid and invalid cases.

Overall, the program performs as expected and all tests cases pass. There is still room for improvement. If I was going to make this a complete program, I would look into improving the way we receive our inputs. Currently, for simplicity, these are hardcode in the Main.java at the top. I think the approach of reading the commands from an input file, would make more sense if this was a set of commands that would be sent over a private channel if we are thinking of it being used in space. Another improvement would to build a UI element for this as its output is returned in the command line. This would help make it more user friendly as at this stage it’s directly used by coding the inputs. 

Currently reading input from the console via user input. Given more time, I would add validation on the inputs read at this stage to ensure we have correct types like direction etc. 
