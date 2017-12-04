package javaclasses.compiler.impl;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.Map;
import java.util.Set;

public abstract class CompilerStateMachine<State extends Enum> extends FiniteStateMachine<CompilationOutput, SourceCodeReader, State, CompilationError> {

    protected Map<State, Set<State>> transitions;


    @Override
    protected Set<State> getPossibleTransitions(State currentState) {
        return transitions.get(currentState);
    }

    @Override
    protected void raiseDeadlockError(State state, SourceCodeReader sourceCodeReader) throws CompilationError {
        throw new CompilationError("Incorrect source.", sourceCodeReader.getParsePosition());
    }

}
