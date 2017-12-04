package javaclasses.compiler.impl.fsm.expression;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.fsm.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.expression.parser.ExpressionParserFactory;

import java.util.HashMap;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.expression.ExpressionState.*;

public class Expression extends CompilerStateMachine<ExpressionState> {

    public Expression() {
        parserFactory = new ExpressionParserFactory();
        transitions = new HashMap<ExpressionState, Set<ExpressionState>>() {{
            put(START, of(CALCULABLE));
            put(CALCULABLE, of(BINARY_OPERATOR, FINISH));
            put(BINARY_OPERATOR, of(CALCULABLE));
        }};
    }

    @Override
    protected boolean isFinishState(ExpressionState currentState) {
        return currentState == FINISH;
    }

}
