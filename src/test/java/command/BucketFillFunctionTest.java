package command;

import domain.Canvas;
import domain.Constants;
import exception.InvalidCommandException;
import exception.InvalidInputParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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
        String params[] = {"10", "3", "o"};
        bucketFillFunction.applyCanvasFunction(inputCanvas, params);

        char resultCanvasArray[][] = inputCanvas.getCanvasArray();
        assertEquals(" Wrong result ", 'o', resultCanvasArray[0][0]);
        assertEquals(" Wrong result ", 'x', resultCanvasArray[15][2]);
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testApplyCanvasFunction_Wrong_NoOf_Params() {
        String params[] = {"10", "3"};
        bucketFillFunction.applyCanvasFunction(inputCanvas, params);
    }

    @Test(expected = InvalidCommandException.class)
    public void testApplyCanvasFunction_Invalid_Color_Param() {
        String params[] = {"10", "3", "oo"};
        try{
            bucketFillFunction.applyCanvasFunction(inputCanvas, params);
        } catch(Exception exception) {
            assertEquals(" Wrong error message returned ", Constants.ERROR_MESSAGE_BUCKET_FILL_INVALID_COLOR_PARAM, exception.getMessage());
            throw exception;
        }
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testApplyCanvasFunction_Negative_Param() {
        String params[] = {"-5", "3", "o"};
        bucketFillFunction.applyCanvasFunction(inputCanvas, params);
    }

    private Canvas getCanvas() {
        Canvas canvas = new Canvas(20, 4);
        fillEmptyCanvasArray(canvas.getCanvasArray());
        fillRectangle(canvas.getCanvasArray());
        return canvas;
    }

    private void fillEmptyCanvasArray(char canvasArray[][]) {
        Stream.of(canvasArray).forEach(chars -> Arrays.fill(chars, ' '));
    }

    private void fillRectangle(char canvasArray[][]) {
        //fill rectangle
        for(int i = 15; i < 20; i++ ) {
            canvasArray[i][0] = Constants.LINE;
            for(int j = 0; j < 3; j++) {
                if((i == 15 || i == 19 || j == 2)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
    }
}
