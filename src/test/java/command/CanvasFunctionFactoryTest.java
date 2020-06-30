package command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 30/06/2020.
 */
public class CanvasFunctionFactoryTest {
    CanvasFunctionFactory commandFactory;
    CanvasFunction canvasFunction;

    @Before
    public void setup() {
        commandFactory = new CanvasFunctionFactory();
    }

    @Test
    public void testGetFunction_Line() {
        canvasFunction = commandFactory.getFunction("L", new String[]{"1","2","6","2"});
        assertEquals(" Unexpected function class ", LineFunction.class, canvasFunction.getClass());
    }

    @Test
    public void testGetFunction_Rectangle() {
        canvasFunction = commandFactory.getFunction("R", new String[]{"16","1","20","3"});
        assertEquals(" Unexpected function class ", RectangleFunction.class, canvasFunction.getClass());
    }

    @Test
    public void testGetFunction_BucketFill() {
        canvasFunction = commandFactory.getFunction("B", new String[]{"10","3","o"});
        assertEquals(" Unexpected function class ", BucketFillFunction.class, canvasFunction.getClass());
    }
}
