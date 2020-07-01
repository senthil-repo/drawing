package render;

import domain.Canvas;
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

}