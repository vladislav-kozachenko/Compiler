package javaclasses.compiler.impl.fsm.scope;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class ExecutionScope extends FiniteStateMachine<List<Command>, SourceCodeReader, ExecutionScopeState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, ExecutionScopeState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(ExecutionScopeState currentState) {
        return false;
    }

    @Override
    protected Set<ExecutionScopeState> getPossibleTransitions(ExecutionScopeState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(ExecutionScopeState executionScopeState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
