package command;

import domain.Canvas;
import domain.Constants;
import exception.InvalidInputParameterException;
import util.Validator;

/**
 * Class to process Bucket fill command, and creates a bucket fill inside the canvas
 * Created on 30/06/2020.
 */
public class BucketFillFunction implements CanvasFunction {
    private char colourParam;
    private char canvasArray[][];

    @Override
    public void applyCanvasFunction(Canvas canvas, String[] params) {
        if(Validator.isBucketParamsValid(params)) {
            if(Integer.parseInt(params[0]) > canvas.getWidth() || Integer.parseInt(params[1]) > canvas.getHeight() )
                throw new InvalidInputParameterException(Constants.ERROR_MESSAGE_BUCKET_FILL_OUTSIDE_RANGE);

            this.colourParam = params[2].charAt(0);
            this.canvasArray = canvas.getCanvasArray();
            fillTheBucket(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
        }
    }

    private void fillTheBucket(int x, int y) {
        //out of bounds - so breakout
        if(x < 0 || y < 0 || x > canvasArray.length-1 || y > canvasArray[0].length-1)
            return;

        //ignore the cells that are already filled with diagram
        if(canvasArray[x][y] != Constants.EMPTY_SPACE)
            return;

        canvasArray[x][y] = colourParam;

        fillTheBucket(x-1, y); // cell left to x
        fillTheBucket(x+1, y); // cell right to x
        fillTheBucket(x, y-1); // cell above y
        fillTheBucket(x, y+1); // cell below y
    }
}
