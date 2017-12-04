package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.ParserFactory;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.scope.ExecutionScopeState.*;

public class ExecutionScopeParserFactory extends ParserFactory<ExecutionScopeState>{

    public ExecutionScopeParserFactory() {
        parsers = new HashMap<ExecutionScopeState, SourceCodeParser>() {{
            put(STATEMENT, new StatementParser());
            put(STATEMENT_END, new StatementEndParser());
            put(FINISH, new FinishParser());
        }};
    }


}
