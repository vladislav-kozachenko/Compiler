package javaclasses.compiler.impl.fsm.expression.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.expression.ExpressionState;
import javaclasses.compiler.impl.fsm.variable.VariableInitializationState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.expression.ExpressionState.*;


public class ExpressionParserFactory {

    private final Map<ExpressionState, SourceCodeParser> parsers = new HashMap<ExpressionState, SourceCodeParser>() {{
        put(CALCULABLE, new CalculableParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(FINISH, new ExpressionFinishParser());
    }};


    public  SourceCodeParser getParser(ExpressionState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }


}
