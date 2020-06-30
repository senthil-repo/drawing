package domain;

/**
 * Created on 30/06/2020.
 */
public class Canvas {
    private char[][] canvasArray;
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvasArray = new char[width][height];
    }
    public char[][] getCanvasArray() {
        return canvasArray;
    }

    public void setCanvasArray(char[][] canvasArray) {
        this.canvasArray = canvasArray;
    }
}
