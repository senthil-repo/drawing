package CreateCanvas;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvas {

    public char[][] createCanvas(String params[]) {
        //validate the params ???

        int width = Integer.parseInt(params[0]);
        int height = Integer.parseInt(params[1]);

        char canvasArray[][] = new char[width][height];
        fillCanvas(canvasArray);
        return canvasArray;
    }

    /**
     * Fill with an empty space
     */
    private void fillCanvas(char canvasArray[][]) {
        Stream.of(canvasArray).forEach(chars -> Arrays.fill(chars, ' '));
    }
}
