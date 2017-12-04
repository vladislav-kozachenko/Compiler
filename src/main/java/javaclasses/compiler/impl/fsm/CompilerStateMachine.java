package javaclasses.compiler.impl.fsm;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.Map;
import java.util.Set;

public abstract class CompilerStateMachine<State extends Enum> extends FiniteStateMachine<CompilationOutput, SourceCodeReader, State, CompilationError> {

    protected Map<State, Set<State>> transitions;
    protected ParserFactory<State> parserFactory;

    @Override
    protected Set<State> getPossibleTransitions(State currentState) {
        return transitions.get(currentState);
    }

    @Override
    protected void raiseDeadlockError(State state, SourceCodeReader sourceCodeReader) throws CompilationError {
        throw new CompilationError("Incorrect source.", sourceCodeReader.getParsePosition());
    }

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, State nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

}
