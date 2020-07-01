package render;

import domain.Canvas;
import domain.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created on 30/06/2020.
 */
public class DrawTest {

    Drawable draw;

    @Before
    public void setup() {
        draw = new Draw();
    }

    @Test
    public void testDraw_Canvas() {
        String result = draw.draw(getInputCanvas());
        assertEquals(" Unexpected drawing ", getExpectedCanvas(), result);
    }

    private Canvas getInputCanvas() {
        Canvas canvas = new Canvas(10, 4);
        Stream.of(canvas.getCanvasArray()).forEach(chars -> Arrays.fill(chars, ' '));
        return canvas;
    }

    private String getExpectedCanvas() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------\n").append("|          |\n").append("|          |\n")
                .append("|          |\n").append("|          |\n").append("------------\n");

        return builder.toString().trim();
    }

    @Test
    public void testDraw_Line() {
        Canvas canvas = getInputCanvas();
        addLineInsideCanvas(canvas);

        String result = draw.draw(canvas);
        assertEquals(" Unexpected drawing ",getExpectedCanvas_With_Line(), result);
    }

    @Test
    public void testDraw_Rectangle() {
        Canvas canvas = getInputCanvas();
        addRectangleInsideCanvas(canvas);

        String result = draw.draw(canvas);
        assertEquals(" Unexpected drawing ",getExpectedCanvas_With_Rectangle(), result);
    }
    private void addLineInsideCanvas(Canvas canvas) {
        char canvasArray[][] = canvas.getCanvasArray();
        for(int i = 0; i < 6 ; i++ ) {
            for(int j = 1; j < 2; j++) {
                canvasArray[i][j] = Constants.LINE;
            }
        }
    }

    private void addRectangleInsideCanvas(Canvas canvas) {
        char canvasArray[][] = canvas.getCanvasArray();
        for(int i = 5; i < 10; i++ ) {
            canvasArray[i][0] = Constants.LINE;
            for(int j = 0; j < 3; j++) {
                if((i == 5 || i == 9 || j == 2)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
    }

    //TODO
/*    private void bucketFill_InsideCanvas(Canvas canvas) {
        char canvasArray[][] = canvas.getCanvasArray();
        for(int i = 5; i < 10; i++ ) {
            canvasArray[i][0] = Constants.LINE;
            for(int j = 0; j < 3; j++) {
                if((i == 5 || i == 9 || j == 2)) {
                    canvasArray[i][j] = Constants.LINE;
                }
            }
        }
    }*/


    private String getExpectedCanvas_With_Line() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------\n").append("|          |\n").append("|xxxxxx    |\n")
                .append("|          |\n").append("|          |\n").append("------------\n");

        return builder.toString().trim();
    }

    private String getExpectedCanvas_With_Rectangle() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------\n").append("|     xxxxx|\n")
                .append("|     x   x|\n").append("|     xxxxx|\n")
                .append("|          |\n").append("------------\n");

        return builder.toString().trim();
    }

/*    private String getExpectedCanvas_With_BucketFill() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------\n").append("| xxxxx|\n")
                .append("| x x|\n").append("| xxxxx|\n")
                .append("| |\n").append("------------\n");

        return builder.toString().trim();
    }*/
}