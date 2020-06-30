package command;

import domain.Canvas;
import domain.Constants;
import domain.Line;

/**
 * Created on 30/06/2020.
 */
public class LineFunction implements CanvasFunction {
    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        Line line = new Line(params);
        fillWithLine(line, canvas.getCanvasArray());
    }

    private void fillWithLine(Line line, char[][] canvasArray) {
        for(int i = line.getX1() - 1; i < line.getX2() ; i++ ) { //row
            for(int j = line.getY1() - 1; j < line.getY2(); j++) { //column
                canvasArray[i][j] = Constants.LINE;
            }
        }
    }
}
