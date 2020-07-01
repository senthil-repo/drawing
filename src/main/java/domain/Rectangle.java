package domain;

/**
 * Created on 30/06/2020.
 */
public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(String[] params) {
        x1 = Integer.parseInt(params[0]);
        y1 = Integer.parseInt(params[1]);
        x2 = Integer.parseInt(params[2]);
        y2 = Integer.parseInt(params[3]);

        //swap in case of row/column params are in descending order
        if(x1 > x2)
            swapX(x1, x2);
        else if(y1 > y2)
            swapY(y1, y2);
    }

    private void swapX(int x1, int x2) {
        int temp = x1;
        this.x1 = x2;
        this.x2 = temp;
    }

    private void swapY(int y1, int y2) {
        int temp = y1;
        this.y1 = y2;
        this.y2 = temp;
    }
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

}
