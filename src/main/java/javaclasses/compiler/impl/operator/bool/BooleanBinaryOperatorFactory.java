package javaclasses.compiler.impl.operator.bool;

import javaclasses.compiler.impl.BooleanBinaryOperator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BooleanBinaryOperatorFactory {
    private final Map<String, BooleanBinaryOperator> operators = new HashMap<String, BooleanBinaryOperator>() {{
        put("==", new EqualityOperator());
    }};

    /**
     * Creates boolean operator by its symbolic designation.
     * @param sign is a String which contains symbolic designation of boolean operator.
     * @return instance of suitable boolean operator.
     */
    public BooleanBinaryOperator getBooleanBinaryOperator(String sign) {

        if (!operators.containsKey(sign)) {
            throw new IllegalStateException("Binary operator not found: " + sign);
        }

        return operators.get(sign);
    }

    public Set<String> getBooleanOperatorSigns() {
        return operators.keySet();
    }

}
