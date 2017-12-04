package javaclasses.compiler.impl.fsm.scope;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.parser.ExecutionScopeParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.scope.ExecutionScopeState.*;

public class ExecutionScope extends FiniteStateMachine<CompilationOutput, SourceCodeReader, ExecutionScopeState, CompilationError> {

    private final ExecutionScopeParserFactory parserFactory = new ExecutionScopeParserFactory();

    private final Map<ExecutionScopeState, Set<ExecutionScopeState>> transitions = new HashMap<ExecutionScopeState, Set<ExecutionScopeState>>() {{
        put(START, of(STATEMENT));
        put(STATEMENT, of(STATEMENT_END));
        put(STATEMENT_END, of(STATEMENT, FINISH));
    }};

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, ExecutionScopeState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(ExecutionScopeState currentState) {
        return currentState == FINISH;
    }

    @Override
    protected Set<ExecutionScopeState> getPossibleTransitions(ExecutionScopeState currentState) {
        return transitions.get(currentState);
    }

    @Override
    protected void raiseDeadlockError(ExecutionScopeState executionScopeState, SourceCodeReader sourceCodeReader) throws CompilationError {
        throw new CompilationError("Incorrect source.", sourceCodeReader.getParsePosition());
    }
}
