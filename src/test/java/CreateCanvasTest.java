import CreateCanvas.CreateCanvas;
import exception.InvalidInputParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvasTest {
    CreateCanvas createCanvas;
    char resultCanvasArray[][];

    @Before
    public void setup() {
        createCanvas = new CreateCanvas();
    }

    @Test
    public void testCreateCanvas() {
        String params[] = {"4", "5"};
        resultCanvasArray = createCanvas.createCanvas(params);

        //expect
        char createCanvasArray[][] = new char[4][5];
        Stream.of(createCanvasArray).forEach(chars -> Arrays.fill(chars, ' '));
        assertArrayEquals(" Wrong characters found ", createCanvasArray, resultCanvasArray);
    }


    @Test(expected = InvalidInputParameterException.class)
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
    }
}
