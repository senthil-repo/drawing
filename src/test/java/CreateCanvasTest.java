import CreateCanvas.CreateCanvas;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvasTest {
    
    @Before
    public void setup() {

    }

    @Test
    public void testCreateCanvas() {
        String params[] = {"4", "5"};
        CreateCanvas createCanvas = new CreateCanvas();
        char resultCanvasArray[][] = createCanvas.createCanvas(params);

        //expect
        char createCanvasArray[][] = new char[4][5];
        Stream.of(createCanvasArray).forEach(chars -> Arrays.fill(chars, ' '));

        assertArrayEquals(" Wrong characters found ", createCanvasArray, resultCanvasArray);
    }


}
