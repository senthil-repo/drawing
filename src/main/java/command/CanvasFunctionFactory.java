package command;

/**
 * Created on 30/06/2020.
 */
public class CanvasFunctionFactory {
    public CanvasFunction getFunction(String command, String[] strings) {
        return new LineFunction();
    }
}
