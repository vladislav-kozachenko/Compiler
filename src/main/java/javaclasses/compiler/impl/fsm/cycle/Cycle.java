package javaclasses.compiler.impl.fsm.cycle;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class Cycle extends FiniteStateMachine<List<Command>, SourceCodeReader, CycleState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, CycleState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(CycleState currentState) {
        return false;
    }

    @Override
    protected Set<CycleState> getPossibleTransitions(CycleState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(CycleState cycleState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
