package javaclasses.compiler.impl.fsm.calculable;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.fsm.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.calculable.parser.CalculableParserFactory;

import java.util.HashMap;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.calculable.CalculableState.*;

public class Calculable extends CompilerStateMachine<CalculableState> {


    public Calculable() {

        parserFactory = new CalculableParserFactory();

        transitions = new HashMap<CalculableState, Set<CalculableState>>() {{
            put(START, of(NUMBER, VARIABLE, FUNCTION_CALL, OPENING_BRACKET));
            put(NUMBER, of(FINISH));
            put(VARIABLE, of(FINISH));
            put(FUNCTION_CALL, of(FINISH));
            put(OPENING_BRACKET, of(EXPRESSION));
            put(EXPRESSION, of(CLOSING_BRACKET));
            put(CLOSING_BRACKET, of(FINISH));
        }};

    }

    @Override
    protected boolean isFinishState(CalculableState currentState) {
        return currentState == FINISH;
    }

}
