package util;

import domain.Constants;
import exception.InvalidCommandException;
import exception.InvalidInputParameterException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created on 30/06/2020.
 */
public class Validator {

    public static boolean isCanvasParamsValid(String[] params) {
        boolean valid;

        //check if params are positive integers
        valid = areParamsPositiveIntegers(params, Constants.ERROR_MESSAGE_CREATE_CANVAS);

        //check if we have 2 valid parameters supplied
        if(!valid || params.length < 2)
            throw new InvalidInputParameterException(Constants.ERROR_MESSAGE_CREATE_CANVAS);

        return valid;
    }

    private static boolean areParamsPositiveIntegers(String input[], String errorMessage) {
        try{
            return Arrays.stream(input).allMatch(s -> StringUtils.isNotBlank(s) && Integer.parseInt(s) > 0);
        }catch(NumberFormatException exception) {
            throw new InvalidInputParameterException(errorMessage);
        }
    }

    public static boolean isLineParamsValid(String params[]) {
        return isParamsValid(params, Constants.ERROR_MESSAGE_LINE_INVALID_PARAMS);
    }

    private static boolean isParamsValid(String params[], String errorMessage) {
        boolean valid;

        //************ TODO *********** check only limited params for this function

        //check if params are positive integers
        valid = areParamsPositiveIntegers(params, errorMessage);

        //check if we have 4 valid parameters supplied
        if(!valid || params.length < 4)
            throw new InvalidInputParameterException(errorMessage);

        return valid;
    }

    public static boolean isRectangleParamsValid(String params[]) {
        return isParamsValid(params, Constants.ERROR_MESSAGE_RECTANGLE_INVALID_PARAMS);
    }

    public static boolean isBucketParamsValid(String params[]) {
        boolean valid;

        //check if params are positive integers
        String tempParams[] = new String[]{params[0], params[1]};
        valid = areParamsPositiveIntegers(tempParams, Constants.ERROR_MESSAGE_BUCKET_FILL_INVALID_PARAMS);

        if (!valid ||params.length < 3)
            throw new InvalidInputParameterException(Constants.ERROR_MESSAGE_BUCKET_FILL_INVALID_PARAMS);
        else if (StringUtils.isBlank(params[2]) || params[2].length() != 1)
            throw new InvalidCommandException(Constants.ERROR_MESSAGE_BUCKET_FILL_INVALID_COLOR_PARAM);

        return valid;
    }

    public static boolean isValidCommandOpertion(String commandPrefix) {
        return commandPrefix.length() == 1 && StringUtils.isAlpha(commandPrefix);
    }
}
