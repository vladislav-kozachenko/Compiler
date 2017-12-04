package javaclasses.compiler.impl.fsm.function;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.function.parser.FunctionCallParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.function.FunctionCallState.*;

public class FunctionCall extends CompilerStateMachine<FunctionCallState> {

    private final FunctionCallParserFactory parserFactory = new FunctionCallParserFactory();

    public FunctionCall() {
        transitions = new HashMap<FunctionCallState, Set<FunctionCallState>>() {{
            put(START, of(FUNCTION_NAME));
            put(FUNCTION_NAME, of(OPENING_BRACKET));
            put(OPENING_BRACKET, of(EXPRESSION));
            put(EXPRESSION, of(ARGUMENT_DELIMITER, CLOSING_BRACKET));
            put(ARGUMENT_DELIMITER, of(EXPRESSION));
            put(CLOSING_BRACKET, of(FINISH));
        }};
    }

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, FunctionCallState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(FunctionCallState currentState) {
        return currentState == FINISH;
    }

}
