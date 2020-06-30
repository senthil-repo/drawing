package command;

import domain.Canvas;
import domain.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created on 30/06/2020.
 */
public class RectangleFunctionTest {
    CanvasFunction rectangleFunction;
    Canvas inputCanvas;

    @Before
    public void setup() {
        rectangleFunction = new RectangleFunction();
        inputCanvas = getCanvas();
    }

    @Test
    public void testRectangleFunction() {
        String params[] = {"5", "1", "10", "3"};
        rectangleFunction.applyCanvasFunction(inputCanvas, params);
        char resultCanvasArray[][] = inputCanvas.getCanvasArray();
        assertArrayEquals(" Unexpected inputCanvas ", getExpectedCanvasArray(), resultCanvasArray);
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

        //fill rectangle
        for(int i = 4; i < 10; i++ ) {
            canvasArray[i][0] = Constants.LINE;
            for(int j = 0; j < 3; j++) {
                if((i == 4 || i == 9 || j == 2)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
        return canvasArray;
    }

}
