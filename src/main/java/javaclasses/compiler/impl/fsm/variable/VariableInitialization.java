package javaclasses.compiler.impl.fsm.variable;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.variable.parser.VariableInitializationParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.variable.VariableInitializationState.*;

public class VariableInitialization extends CompilerStateMachine<VariableInitializationState> {

    private final VariableInitializationParserFactory parserFactory = new VariableInitializationParserFactory();

    public VariableInitialization() {
        transitions = new HashMap<VariableInitializationState, Set<VariableInitializationState>>() {{
            put(START, of(VARIABLE_NAME));
            put(VARIABLE_NAME, of(ASSIGN));
            put(ASSIGN, of(EXPRESSION));
            put(EXPRESSION, of(FINISH));
        }};
    }


    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, VariableInitializationState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(VariableInitializationState currentState) {
        return currentState == FINISH;
    }

}
