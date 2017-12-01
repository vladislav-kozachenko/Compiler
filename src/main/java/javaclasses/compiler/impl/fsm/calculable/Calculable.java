package javaclasses.compiler.impl.fsm.calculable;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.calculable.parser.CalculableParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.calculable.CalculableState.*;

public class Calculable extends FiniteStateMachine<List<Command>, SourceCodeReader, CalculableState, CompilationError> {

    private final CalculableParserFactory parserFactory = new CalculableParserFactory();

    private final Map<CalculableState, Set<CalculableState>> transitions = new HashMap<CalculableState, Set<CalculableState>>() {{
        put(START, of(NUMBER, FUNCTION_CALL, OPENING_BRACKET));
        put(NUMBER, of(FINISH));
        put(FUNCTION_CALL, of(FINISH));
        put(OPENING_BRACKET, of(EXPRESSION));
        put(EXPRESSION, of(CLOSING_BRACKET));
        put(CLOSING_BRACKET, of(FINISH));
    }};


    @Override
    protected boolean acceptState(SourceCodeReader reader, List<Command> commands, CalculableState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(CalculableState currentState) {
        return currentState == FINISH;
    }

    @Override
    protected Set<CalculableState> getPossibleTransitions(CalculableState currentState) {
        return transitions.get(currentState);
    }

    @Override
    protected void raiseDeadlockError(CalculableState calculableState, SourceCodeReader sourceCodeReader) throws CompilationError {

    }
}
