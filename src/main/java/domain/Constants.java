package domain;

/**
 * Created on 30/06/2020.
 */
public class Constants {
    public static final String ERROR_MESSAGE_CREATE_CANVAS = " Invalid parameters - unable to create canvas. Two positive integers (width & height) are required. ";
    public static final String ERROR_MESSAGE_LINE_INVALID_PARAMS = " Invalid parameters - unable to create line. Four positive integers (x1, y1, x2, y2) are required. ";
    public static final String ERROR_MESSAGE_LINE_DIAGONAL_NOT_SUPPORTED = " Sorry, diagonal lines are not supported. Only horizontal or vertical lines are supported ";
    public static final String ERROR_MESSAGE_LINE_OUTSIDE_CANVAS = "Invalid parameters - - unable to create line. Supplied parameters should be within canvas size range ";
    public static final String ERROR_MESSAGE_RECTANGLE_INVALID_PARAMS = " Invalid parameters - unable to create rectangle. Four positive integers (x1, y1, x2, y2) are required. ";
    public static final String ERROR_MESSAGE_RECTANGLE_OUTSIDE_CANVAS = "Invalid parameters - - unable to create rectangle. Supplied parameters should be within canvas size range ";
    public static final String ERROR_MESSAGE_BUCKET_FILL_INVALID_PARAMS = " Invalid parameters - unable to fill the bucket. Two positive integers followed with a character are required. ";
    public static final String ERROR_MESSAGE_BUCKET_FILL_INVALID_COLOR_PARAM = " Invalid color parameter supplied - unable to fill the bucket. Color param should only be 1 character ";
    public static final String ERROR_MESSAGE_BUCKET_FILL_OUTSIDE_RANGE = "Invalid range of params - unable to fill the bucket. Integers parameters should be within canvas size range ";

    public static final char LINE = 'x';
    public static final char HORIZONTAL = '-';
    public static final char VERTICAL = '|';
    public static final char EMPTY_SPACE = ' ';

    public static final String ERROR_MESSAGE_INVALID_COMMAND_SUPPLIED = " Invalid command supplied. Please enter a valid command e.g 'C 20 4' ";
    public static final String ERROR_MESSAGE_INVALID_COMMAND_OPERATION = " Invalid command operation supplied. Please enter a valid command prefix e.g 'C or L or R or B' ";
    public static final String ERROR_MESSAGE_INVALID_COMMAND_SEQUENCE = " Wrong sequence of command supplied. Please supply a create command first, before draw a line/rectangle/bucket fill ";
}
