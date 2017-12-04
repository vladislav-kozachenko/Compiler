package javaclasses.compiler.impl.fsm.expression;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.expression.parser.ExpressionParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.expression.ExpressionState.*;

public class Expression extends CompilerStateMachine<ExpressionState> {

    private final ExpressionParserFactory parserFactory = new ExpressionParserFactory();

    public Expression() {
        transitions = new HashMap<ExpressionState, Set<ExpressionState>>() {{
            put(START, of(CALCULABLE));
            put(CALCULABLE, of(BINARY_OPERATOR, FINISH));
            put(BINARY_OPERATOR, of(CALCULABLE));
        }};
    }

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, ExpressionState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(ExpressionState currentState) {
        return currentState == FINISH;
    }

}
