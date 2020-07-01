package command;

import domain.Canvas;
import domain.Constants;
import domain.Line;
import exception.InvalidInputParameterException;
import util.Validator;

/**
 * Class to process Line command, and creates a line inside the canvas
 * Created on 30/06/2020.
 */
public class LineFunction implements CanvasFunction {
    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        if(Validator.isLineParamsValid(params)) {//validate the params
            Line line = new Line(params);
            if (isOutsideOfRange(line.getX1(), line.getY1(), canvas.getWidth(), canvas.getHeight())
                    || isOutsideOfRange(line.getX2(), line.getY2(), canvas.getWidth(), canvas.getHeight())) {
                throw new InvalidInputParameterException(Constants.ERROR_MESSAGE_LINE_OUTSIDE_CANVAS);
            }

            fillWithLine(line, canvas.getCanvasArray());
        }
    }

    private void fillWithLine(Line line, char[][] canvasArray) {
        for(int i = line.getX1() - 1; i < line.getX2() ; i++ ) { //row
            for(int j = line.getY1() - 1; j < line.getY2(); j++) { //column
                canvasArray[i][j] = Constants.LINE;
            }
        }
    }

    private boolean isOutsideOfRange(int x, int y, int width, int height) {
        return x < 1 || x >= width || y < 1 || y >= height;
    }
}
