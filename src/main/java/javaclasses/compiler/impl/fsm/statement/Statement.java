package javaclasses.compiler.impl.fsm.statement;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.fsm.FiniteStateMachine;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.statement.parser.StatementParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.statement.StatementState.*;

public class Statement extends CompilerStateMachine<StatementState> {

    private final StatementParserFactory parserFactory = new StatementParserFactory();

    public Statement() {
        transitions = new HashMap<StatementState, Set<StatementState>>() {{
            put(START, of(VARIABLE_INITIALIZATION, FUNCTION_CALL, CYCLE));
            put(VARIABLE_INITIALIZATION, of(FINISH));
            put(FUNCTION_CALL, of(FINISH));
            put(CYCLE, of(FINISH));
        }};
    }

    @Override
    protected boolean acceptState(SourceCodeReader reader, CompilationOutput commands, StatementState nextState) throws CompilationError {
        final SourceCodeParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, commands);
    }

    @Override
    protected boolean isFinishState(StatementState currentState) {
        return currentState == FINISH;
    }

}
