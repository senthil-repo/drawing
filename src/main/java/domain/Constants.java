package domain;

/**
 * Created on 30/06/2020.
 */
public class Constants {
    public static final String ERROR_MESSAGE_CREATE_CANVAS = " Invalid parameters - unable to create canvas. Two positive integers (width & height) are required. ";
    public static final String ERROR_MESSAGE_LINE_INVALID_PARAMS = " Invalid parameters - unable to create line. Four positive integers (x1, y1, x2, y2) are required. ";
    public static final String ERROR_MESSAGE_LINE_DIAGONAL_NOT_SUPPORTED = " Sorry, diagonal lines are not supported. Only horizontal or vertical lines are supported ";
    public static final String ERROR_MESSAGE_RECTANGLE_INVALID_PARAMS = " Invalid parameters - unable to create rectangle. Four positive integers (x1, y1, x2, y2) are required. ";

    public static final char LINE = 'x';
    public static final char HORIZONTAL = '-';
    public static final char VERTICAL = '|';
}
