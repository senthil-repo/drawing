package CreateCanvas;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvas {

    public char[][] createCanvas(String params[]) {
        int width = Integer.parseInt(params[0]);
        int height = Integer.parseInt(params[1]);

        char canvasArray[][] = new char[width][height];
        return canvasArray;
    }
}
