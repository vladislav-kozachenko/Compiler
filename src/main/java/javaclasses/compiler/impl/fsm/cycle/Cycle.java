package javaclasses.compiler.impl.fsm.cycle;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.cycle.parser.CycleParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.cycle.CycleState.*;

public class Cycle extends CompilerStateMachine<CycleState> {

    private final CycleParserFactory parserFactory = new CycleParserFactory();

    public Cycle() {
        transitions = new HashMap<CycleState, Set<CycleState>>() {{
            put(START, of(WHILE));
            put(WHILE, of(OPENING_BRACKET));
            put(OPENING_BRACKET, of(BOOLEAN_CONDITION));
            put(BOOLEAN_CONDITION, of(CLOSING_BRACKET));
            put(CLOSING_BRACKET, of(OPENING_BRACE));
            put(OPENING_BRACE, of(EXECUTION_SCOPE));
            put(EXECUTION_SCOPE, of(CLOSING_BRACE));
            put(CLOSING_BRACE, of(FINISH));
        }};
    }

    @Override
    protected boolean acceptState(SourceCodeReader sourceCodeReader, CompilationOutput commands, CycleState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(sourceCodeReader, commands);
    }

    @Override
    protected boolean isFinishState(CycleState currentState) {
        return currentState == FINISH;
    }

}
