package command;

import exception.InvalidCommandException;

/**
 * Created on 30/06/2020.
 */
public class CanvasFunctionFactory {
    public CanvasFunction getFunction(String commandOperation, String[] strings) {
        switch (commandOperation) {
            case "L":
                return new LineFunction();
            case "R":
                return new RectangleFunction();
            case "B":
                return new BucketFillFunction();
            default:
                throw new InvalidCommandException(" Invalid command supplied. Please enter a valid command e.g 'C 20 4' ");
        }
    }
}
