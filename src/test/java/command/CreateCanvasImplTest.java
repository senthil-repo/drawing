package command;

import domain.Canvas;
import exception.InvalidInputParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvasImplTest {
    CreateCanvas canvasCommand;
    Canvas canvas;

    @Before
    public void setup() {
        canvasCommand = new CreateCanvasImpl();
    }

    @Test
    public void testCreateCanvas() {
        String params[] = {"4", "5"};
        canvas = canvasCommand.createCanvas(params);
        assertNotNull(" Unexpected result ", canvas);

        char resultCanvasArray[][] = canvas.getCanvasArray();
        char expectedArray[][] = new char[4][5];
        Stream.of(expectedArray).forEach(chars -> Arrays.fill(chars, ' '));

        assertArrayEquals(" Wrong characters found ", expectedArray, resultCanvasArray);
    }

/*    @Test(expected = InvalidInputParameterException.class)
    public void testCreateCanvas_NegativeParams() {
        String params[] = {"-2", "2"};
        resultCanvasArray = createCanvas.createCanvas(params);
        assertNull(resultCanvasArray);
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testCreateCanvas_BlankParams() {
        String params[] = {" ", "3"};
        resultCanvasArray = createCanvas.createCanvas(params);
        assertNull(resultCanvasArray);
    }

    @Test(expected = InvalidInputParameterException.class)
    public void testCreateCanvas_InvalidLength() {
        String params[] = {"3"};
        resultCanvasArray = createCanvas.createCanvas(params);
        assertNull(" Unexpected result ", resultCanvasArray);
    }*/
}
