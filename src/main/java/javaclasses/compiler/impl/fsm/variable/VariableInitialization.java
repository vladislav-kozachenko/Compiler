package javaclasses.compiler.impl.fsm.variable;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class VariableInitialization extends FiniteStateMachine<List<Command>, SourceCodeReader, VariableInitializationState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, VariableInitializationState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(VariableInitializationState currentState) {
        return false;
    }

    @Override
    protected Set<VariableInitializationState> getPossibleTransitions(VariableInitializationState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(VariableInitializationState variableInitializationState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
