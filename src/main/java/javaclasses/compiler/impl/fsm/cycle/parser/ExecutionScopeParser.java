package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.scope.ExecutionScope;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.List;

public class ExecutionScopeParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (!code.isEmpty()) {
            new ExecutionScope().start(ExecutionScopeState.START, reader, output);
            return true;
        }

        return false;
    }
}
