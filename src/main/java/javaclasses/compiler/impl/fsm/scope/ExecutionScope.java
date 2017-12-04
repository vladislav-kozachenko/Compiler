package javaclasses.compiler.impl.fsm.scope;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.parser.ExecutionScopeParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.scope.ExecutionScopeState.*;

public class ExecutionScope extends CompilerStateMachine<ExecutionScopeState> {

    private final ExecutionScopeParserFactory parserFactory = new ExecutionScopeParserFactory();

    public ExecutionScope(){
        transitions = new HashMap<ExecutionScopeState, Set<ExecutionScopeState>>() {{
            put(START, of(STATEMENT));
            put(STATEMENT, of(STATEMENT_END));
            put(STATEMENT_END, of(STATEMENT, FINISH));
        }};
    }

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, ExecutionScopeState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(ExecutionScopeState currentState) {
        return currentState == FINISH;
    }

}
