package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Appa on 30/06/2020.
 */
public class ValidatorTest {

    Validator validator;

    @Before
    public void setup() {
        validator = new Validator();
    }

    @Test
    public void testIsCanvasParamsValid() {
        String params[] = {"10", "4"};
        boolean isValid = validator.isCanvasParamsValid(params);
        assertTrue(" Unexpected result ", isValid);
    }

    @Test
    public void testIsCanvasParamsValid_EmptyParam() {
        String params[] = {"", ""};
        boolean isValid = validator.isCanvasParamsValid(params);
        assertFalse(" Unexpected result ", isValid);
    }

    @Test
    public void testIsCanvasParamsValid_NegativeParam() {
        String params[] = {"-3", "2"};
        boolean isValid = validator.isCanvasParamsValid(params);
        assertFalse(" Unexpected result ", isValid);
    }
}
