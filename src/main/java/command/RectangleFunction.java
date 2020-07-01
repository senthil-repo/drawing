package command;

import domain.Canvas;
import domain.Constants;
import domain.Rectangle;
import exception.InvalidInputParameterException;
import util.Validator;

/**
 * Class to process Rectangle command, and creates a rectangle inside the canvas
 * Created on 30/06/2020.
 */
public class RectangleFunction implements CanvasFunction {
    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        if(Validator.isRectangleParamsValid(params)) {//validate the params
            Rectangle rectangle = new Rectangle(params);

            if (isOutsideOfRange(rectangle.getX1(), rectangle.getY1(), canvas.getWidth(), canvas.getHeight())
                    || isOutsideOfRange(rectangle.getX2(), rectangle.getY2(), canvas.getWidth(), canvas.getHeight())) {
                throw new InvalidInputParameterException(Constants.ERROR_MESSAGE_RECTANGLE_OUTSIDE_CANVAS);
            }

            fillWithRectangle(rectangle, canvas.getCanvasArray());
        }
    }

    private void fillWithRectangle(Rectangle rectangle, char[][] canvasArray) {
        for(int i = rectangle.getX1()-1; i < rectangle.getX2(); i++ ) { //row
            canvasArray[i][rectangle.getY1()-1] = Constants.LINE;
            for(int j = rectangle.getY1()-1; j < rectangle.getY2(); j++) { //column
                if((i == rectangle.getX1()-1 || i == rectangle.getX2()-1 || j == rectangle.getY2()-1)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
    }

    private boolean isOutsideOfRange(int x, int y, int width, int height) {
        return x < 1 || x > width || y < 1 || y > height;
    }
}
