package util;

import domain.Constants;
import exception.InvalidInputParameterException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created on 30/06/2020.
 */
public class Validator {

    public boolean isCanvasParamsValid(String[] params) {
        boolean valid;

        //check if params are positive integers
        valid = areParamsPositiveIntegers(params, Constants.ERROR_MESSAGE_CREATE_CANVAS);

        return valid;
    }

    public static boolean areParamsPositiveIntegers(String input[], String errorMessage) {
        try{
            return Arrays.stream(input).allMatch(s -> StringUtils.isNotBlank(s) && Integer.parseInt(s) > 0);
        }catch(NumberFormatException exception) {
            throw new InvalidInputParameterException(errorMessage);
        }
    }
}
