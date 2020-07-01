package render;

import domain.Canvas;
import domain.Constants;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 30/06/2020.
 */
public class Draw implements Drawable {
    @Override
    public String draw(Canvas canvas) {
        //create a string of '_' which will be the top and bottom line of the canvas.
        //Note: additional 2 '_' added, which represents the left and right corner/edge of the canvas
        String topAndBottomLine = Stream.generate(() -> String.valueOf(Constants.HORIZONTAL)).limit(canvas.getWidth() + 2).collect(Collectors.joining());

        StringBuilder builder = new StringBuilder();
        builder.append(topAndBottomLine).append("\n");
        for (int i = 0; i < canvas.getHeight(); i++) {
            builder.append(Constants.VERTICAL);
            for (int j = 0; j < canvas.getWidth(); j++) {
                builder.append(canvas.getCanvasArray()[j][i]);
            }
            builder.append(Constants.VERTICAL);
            builder.append("\n");
        }
        builder.append(topAndBottomLine);
        return builder.toString();
    }
}
