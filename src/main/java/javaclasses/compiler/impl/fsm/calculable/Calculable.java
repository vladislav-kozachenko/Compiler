package javaclasses.compiler.impl.fsm.calculable;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class Calculable extends FiniteStateMachine<List<Command>, SourceCodeReader, CalculableState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, CalculableState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(CalculableState currentState) {
        return false;
    }

    @Override
    protected Set<CalculableState> getPossibleTransitions(CalculableState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(CalculableState calculableState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
