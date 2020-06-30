package command;

import domain.Canvas;
import domain.Constants;
import domain.Rectangle;
import util.Validator;

/**
 * Created on 30/06/2020.
 */
public class RectangleFunction implements CanvasFunction {
    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        if(Validator.isRectangleParamsValid(params)) {//validate the params
            Rectangle rectangle = new Rectangle(params);
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
}
