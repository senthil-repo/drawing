import command.CanvasFunction;
import command.CanvasFunctionFactory;
import command.CreateCanvasImpl;
import domain.Canvas;
import domain.Constants;
import exception.InvalidCommandException;
import exception.InvalidInputParameterException;
import org.apache.commons.lang3.StringUtils;
import render.Draw;
import render.Drawable;
import util.Validator;

import java.util.Scanner;
import java.util.stream.Stream;

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
                //********* call the command operation *********
                canvas = process(scanner.nextLine(), canvas);

                //********* draw the diagram to the console *********
                System.out.println(draw.draw(canvas));

            } catch(InvalidCommandException | InvalidInputParameterException exception) {
                System.out.println(" Unable to process your command for the following reason : "+ exception.getMessage());
            }
            System.out.print("enter command: ");
        }
    }

    private Canvas process(String input, Canvas canvas) {
        if (StringUtils.isBlank(input))
            throw new InvalidCommandException(Constants.ERROR_MESSAGE_INVALID_COMMAND_SUPPLIED);

        input = input.trim().replaceAll(" {2,}", " "); // any unwanted spaces will be ignored
        String tokens[] = input.split(" ");
        String commandOperation = tokens[0].toUpperCase();
        tokens = Stream.of(tokens).skip(1).toArray(String[]::new);

        if (!Validator.isValidCommandOpertion(commandOperation))
            throw new InvalidCommandException(Constants.ERROR_MESSAGE_INVALID_COMMAND_OPERATION);

        if (commandOperation.equals("C")) {
            canvas = new CreateCanvasImpl().createCanvas(tokens);
        } else if (commandOperation.equals("Q")) {
            System.exit(0);
        } else {
            if(canvas == null) {
                throw new InvalidCommandException(Constants.ERROR_MESSAGE_INVALID_COMMAND_SEQUENCE);
            }

            CanvasFunction command = new CanvasFunctionFactory().getFunction(commandOperation, tokens);
            command.applyCanvasFunction(canvas, tokens);
        }
        return canvas;
    }
}
