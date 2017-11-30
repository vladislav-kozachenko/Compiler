package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.statement.StatementState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.statement.StatementState.*;


public class StatementParserFactory {

    private final Map<StatementState, SourceCodeParser> parsers = new HashMap<StatementState, SourceCodeParser>() {{
        put(VARIABLE_INITIALIZATION, new VariableInitializationParser());
        put(FUNCTION_CALL, new FunctionCallParser());
        put(CYCLE, new CycleParser());
    }};


    public  SourceCodeParser getParser(StatementState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
