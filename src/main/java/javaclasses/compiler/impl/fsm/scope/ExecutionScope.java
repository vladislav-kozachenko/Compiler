package javaclasses.compiler.impl.fsm.scope;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.fsm.CompilerStateMachine;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.parser.ExecutionScopeParserFactory;

import java.util.HashMap;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.compiler.impl.fsm.scope.ExecutionScopeState.*;

public class ExecutionScope extends CompilerStateMachine<ExecutionScopeState> {


    public ExecutionScope(){
        parserFactory = new ExecutionScopeParserFactory();
        transitions = new HashMap<ExecutionScopeState, Set<ExecutionScopeState>>() {{
            put(START, of(STATEMENT));
            put(STATEMENT, of(STATEMENT_END));
            put(STATEMENT_END, of(STATEMENT, FINISH));
        }};
    }

    @Override
    protected boolean isFinishState(ExecutionScopeState currentState) {
        return currentState == FINISH;
    }

}
