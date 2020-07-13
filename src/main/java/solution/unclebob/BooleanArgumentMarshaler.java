package solution.unclebob;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static solution.unclebob.ArgsException.ErrorCode.MISSING_BOOLEAN;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            booleanValue = Boolean.parseBoolean(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_BOOLEAN);
        }
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}
