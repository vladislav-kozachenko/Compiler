package javaclasses.compiler.impl.fsm.statement;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.List;
import java.util.Set;

public class Statement extends FiniteStateMachine<List<Command>, SourceCodeReader, StatementState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, StatementState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(StatementState currentState) {
        return false;
    }

    @Override
    protected Set<StatementState> getPossibleTransitions(StatementState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(StatementState statementState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
