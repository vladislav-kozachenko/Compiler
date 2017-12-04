package javaclasses.compiler.impl.fsm.cycle;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.fsm.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.cycle.parser.CycleParserFactory;

import java.util.HashMap;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.cycle.CycleState.*;

public class Cycle extends CompilerStateMachine<CycleState> {


    public Cycle() {
        parserFactory = new CycleParserFactory();
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
    protected boolean isFinishState(CycleState currentState) {
        return currentState == FINISH;
    }

}
