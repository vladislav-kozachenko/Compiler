package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.scope.ExecutionScopeState.*;

public class ExecutionScopeParserFactory  {

    private final Map<ExecutionScopeState, SourceCodeParser> parsers = new HashMap<ExecutionScopeState, SourceCodeParser>() {{
        put(STATEMENT, new StatementParser());
        put(STATEMENT_END, new StatementEndParser());
    }};


    public  SourceCodeParser getParser(ExecutionScopeState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
