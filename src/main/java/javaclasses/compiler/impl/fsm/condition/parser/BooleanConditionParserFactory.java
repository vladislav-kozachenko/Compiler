package javaclasses.compiler.impl.fsm.condition.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.common.parser.ExpressionParser;
import javaclasses.compiler.impl.fsm.condition.BooleanConditionState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.condition.BooleanConditionState.*;


public class BooleanConditionParserFactory {

    private final Map<BooleanConditionState, SourceCodeParser> parsers = new HashMap<BooleanConditionState, SourceCodeParser>() {{
        put(EXPRESSION, new ExpressionParser());
        put(BOOLEAN_BINARY_OPERATOR, new BooleanBinaryOperatorParser());
        put(FINISH, new BooleanConditionFinishParser());
    }};


    public  SourceCodeParser getParser(BooleanConditionState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
