package javaclasses.compiler.impl.fsm.function;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class FunctionCall extends FiniteStateMachine<List<Command>, SourceCodeReader, FunctionCallState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, FunctionCallState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(FunctionCallState currentState) {
        return false;
    }

    @Override
    protected Set<FunctionCallState> getPossibleTransitions(FunctionCallState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(FunctionCallState functionCallState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
