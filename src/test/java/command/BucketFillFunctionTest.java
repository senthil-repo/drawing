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
public class BucketFillFunctionTest {
    CanvasFunction bucketFillFunction;
    Canvas inputCanvas;

    @Before
    public void setup() {
        bucketFillFunction = new BucketFillFunction();
        inputCanvas = getCanvas();
    }

    @Test
    public void testApplyCanvasFunction() {
        String params[] = {"5", "2", "o"};
        bucketFillFunction.applyCanvasFunction(inputCanvas, params);

        char resultCanvasArray[][] = inputCanvas.getCanvasArray();
        assertArrayEquals(" Wrong result ", getExpectedCanvasArray(), resultCanvasArray);
    }

    private Canvas getCanvas() {
        Canvas canvas = new Canvas(20, 4);
        fillCanvasArray(canvas.getCanvasArray());
        return canvas;
    }

    private void fillCanvasArray(char canvasArray[][]) {
        Stream.of(canvasArray).forEach(chars -> Arrays.fill(chars, 'o'));
    }

    private char[][] getExpectedCanvasArray() {
        char canvasArray[][] = new char[20][4];
        fillCanvasArray(canvasArray);

        //fill bucket
        for(int i = 16; i < 20; i++ ) {
            canvasArray[i][0] = Constants.LINE;
            for(int j = 0; j < 3; j++) {
                if((i == 16 || i == 19 || j == 2)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
        return canvasArray;
    }
}
