import domain.Canvas;
import exception.InvalidCommandException;
import exception.InvalidInputParameterException;
import render.Draw;
import render.Drawable;

import java.util.Scanner;

/**
 * Created on 30/06/2020.
 */
public class CanvasApplication {

    public static void main(String[] args) {
        CanvasApplication canvasApplication = new CanvasApplication();
        canvasApplication.run();
    }

    private void run() {
        Canvas canvas = null;
        Drawable draw = new Draw();

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter command: ");
        while(true) {
            try{

                //call the operations

                System.out.println(draw.draw(canvas));
            } catch(InvalidCommandException | InvalidInputParameterException exception) {
                System.out.println(" Unable to process your command for the following reason : "+ exception.getMessage());
            }
            System.out.print("enter command: ");
        }
    }
}
