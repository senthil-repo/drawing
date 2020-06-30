package command;

import domain.Canvas;
import domain.Constants;
import exception.InvalidInputParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created on 30/06/2020.
 */
public class LineFunctionTest {
    CanvasFunction lineFunction;
    Canvas inputCanvas;

    @Before
    public void setup() {
        lineFunction = new LineFunction();
        inputCanvas = getCanvas();
    }

    @Test
    public void testapplyCanvasFunction() {
        String params[] = {"1", "2", "6", "2"};
        lineFunction.applyCanvasFunction(inputCanvas, params);

        char resultCanvasArray[][] = inputCanvas.getCanvasArray();
        assertArrayEquals(" Wrong result ", getExpectedCanvasArray(), resultCanvasArray);
    }

    @Test(expected = InvalidInputParameterException.class )
    public void testApplyCanvasFunction_NegativeParams() {
        String params[] = {"-1", "2", "6", "2"};
        lineFunction.applyCanvasFunction(inputCanvas, params);
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testApplyCanvasFunction_InvalidLength() {
        String params[] = {"1", "2", "6"};
        try {
            lineFunction.applyCanvasFunction(inputCanvas, params);
        } catch (InvalidInputParameterException exception) {
            assertEquals(" Wrong error message returned ", Constants.ERROR_MESSAGE_LINE_INVALID_PARAMS, exception.getMessage());
            throw exception;
        }
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testApplyCanvasFunction_Diagonal_Not_Supported() {
        String params[] = {"1", "2", "3", "4"};
        try{
            lineFunction.applyCanvasFunction(inputCanvas, params);
            //fail("Diagonal lines are not supported");
        } catch (InvalidInputParameterException exception) {
            assertEquals(" Wrong error message returned ", Constants.ERROR_MESSAGE_LINE_DIAGONAL_NOT_SUPPORTED, exception.getMessage());
            throw exception;
        }
    }

    @Test
    public void testapplyCanvasFunction_DescendingOrder_Params() {
        String params[] = {"6", "2", "1", "2"};
        lineFunction.applyCanvasFunction(inputCanvas, params);

        char resultCanvasArray[][] = inputCanvas.getCanvasArray();
        assertArrayEquals(" Wrong result ", getExpectedCanvasArray(), resultCanvasArray);
    }

    private Canvas getCanvas() {
        Canvas canvas = new Canvas(10, 4);
        fillCanvasArray(canvas.getCanvasArray());
        return canvas;
    }

    private void fillCanvasArray(char canvasArray[][]) {
        Stream.of(canvasArray).forEach(chars -> Arrays.fill(chars, ' '));
    }

    private char[][] getExpectedCanvasArray() {
        char canvasArray[][] = new char[10][4];
        fillCanvasArray(canvasArray);

        //fill line
        for(int i = 0; i < 6 ; i++ ) {
            for(int j = 1; j < 2; j++) {
                canvasArray[i][j] = Constants.LINE; //TODO move to constants
            }
        }
        return canvasArray;
    }
}
