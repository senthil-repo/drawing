package command;

import domain.Canvas;
import domain.Constants;
import domain.Rectangle;

/**
 * Created on 30/06/2020.
 */
public class RectangleFunction implements CanvasFunction {
    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        Rectangle rectangle = new Rectangle(params);
    }
}
