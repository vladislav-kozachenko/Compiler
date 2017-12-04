package javaclasses.compiler.impl.fsm.condition;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.fsm.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.condition.parser.BooleanConditionParserFactory;

import java.util.HashMap;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.condition.BooleanConditionState.*;

public class BooleanCondition extends CompilerStateMachine<BooleanConditionState> {


    public BooleanCondition() {

        parserFactory = new BooleanConditionParserFactory();

        transitions = new HashMap<BooleanConditionState, Set<BooleanConditionState>>() {{
            put(START, of(LEFT_EXPRESSION));
            put(LEFT_EXPRESSION, of(BOOLEAN_BINARY_OPERATOR));
            put(BOOLEAN_BINARY_OPERATOR, of(RIGHT_EXPRESSION));
            put(RIGHT_EXPRESSION, of(FINISH));
        }};

    }

    @Override
    protected boolean isFinishState(BooleanConditionState currentState) {
        return currentState == FINISH;
    }

}
