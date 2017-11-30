package javaclasses.compiler.impl.fsm.statement;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;
import javaclasses.compiler.impl.fsm.statement.parser.StatementParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.statement.StatementState.*;

public class Statement extends FiniteStateMachine<List<Command>, SourceCodeReader, StatementState, CompilationError> {

    private final StatementParserFactory parserFactory = new StatementParserFactory();

    private final Map<StatementState, Set<StatementState>> transitions = new HashMap<StatementState, Set<StatementState>>() {{
        put(START, of(VARIABLE_INITIALIZATION, FUNCTION_CALL, CYCLE));
        put(VARIABLE_INITIALIZATION, of(FINISH));
        put(FUNCTION_CALL, of(FINISH));
        put(CYCLE, of(FINISH));
    }};


    @Override
    protected boolean acceptState(SourceCodeReader reader, List<Command> commands, StatementState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(StatementState currentState) {
        return currentState == FINISH;
    }

    @Override
    protected Set<StatementState> getPossibleTransitions(StatementState currentState) {
        return transitions.get(currentState);
    }

    @Override
    protected void raiseDeadlockError(StatementState statementState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
