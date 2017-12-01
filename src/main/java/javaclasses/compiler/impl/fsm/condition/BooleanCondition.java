package javaclasses.compiler.impl.fsm.condition;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

public class BooleanCondition extends FiniteStateMachine<List<Command>, SourceCodeReader, BooleanConditionState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, BooleanConditionState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(BooleanConditionState currentState) {
        return false;
    }

    @Override
    protected Set<BooleanConditionState> getPossibleTransitions(BooleanConditionState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(BooleanConditionState booleanConditionState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
