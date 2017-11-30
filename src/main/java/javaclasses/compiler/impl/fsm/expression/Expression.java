package javaclasses.compiler.impl.fsm.expression;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;
import java.util.Set;

import static javaclasses.compiler.impl.fsm.expression.ExpressionState.*;

public class Expression extends FiniteStateMachine<List<Command>, SourceCodeReader, ExpressionState, CompilationError> {
    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, List<Command> commands, ExpressionState nextState) throws CompilationError {
        return false;
    }

    @Override
    protected boolean isFinishState(ExpressionState currentState) {
        return currentState == FINISH;
    }

    @Override
    protected Set<ExpressionState> getPossibleTransitions(ExpressionState currentState) {
        return null;
    }

    @Override
    protected void raiseDeadlockError(ExpressionState expressionState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
