package command;

import domain.Canvas;
import util.Validator;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvasImpl implements CreateCanvas{

    public CreateCanvasImpl() {}

    public Canvas createCanvas(String params[]) {
        Canvas canvas = null;
        if(Validator.isCanvasParamsValid(params)) {
            canvas = new Canvas(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            fillCanvas(canvas);
        }
        return canvas;
    }

    /**
     * Fill with an empty space
     */
    private void fillCanvas(Canvas canvas) {
        Stream.of(canvas.getCanvasArray()).forEach(chars -> Arrays.fill(chars, ' '));
    }
}
