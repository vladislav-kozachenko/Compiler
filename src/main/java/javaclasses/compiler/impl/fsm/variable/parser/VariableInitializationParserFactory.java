package javaclasses.compiler.impl.fsm.variable.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.common.parser.AcceptFinish;
import javaclasses.compiler.impl.fsm.common.parser.ExpressionParser;
import javaclasses.compiler.impl.fsm.variable.VariableInitializationState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.variable.VariableInitializationState.*;

public class VariableInitializationParserFactory {

    private final Map<VariableInitializationState, SourceCodeParser> parsers = new HashMap<VariableInitializationState, SourceCodeParser>() {{
        put(VARIABLE_NAME, new VariableNameParser());
        put(ASSIGN, new AssignVariableParser());
        put(EXPRESSION, new ExpressionParser());
        put(FINISH, new AcceptFinish());
    }};


    public  SourceCodeParser getParser(VariableInitializationState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
