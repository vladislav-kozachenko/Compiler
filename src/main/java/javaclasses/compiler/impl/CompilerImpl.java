package javaclasses.compiler.impl;

import javaclasses.compiler.Command;
import javaclasses.compiler.Compiler;
import javaclasses.compiler.impl.fsm.scope.ExecutionScope;
import javaclasses.compiler.impl.fsm.scope.ExecutionScopeState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompilerImpl implements Compiler {
    @Override
    public CompilationOutput compile(String sourceCode) throws Exception {
        SourceCodeReader reader = new SourceCodeReader(sourceCode);
        CompilationOutput output = new CompilationOutput();
        new ExecutionScope().start(ExecutionScopeState.START, reader, output);
        return output;
    }

    @Override
    public Optional execute(CompilationOutput executionScope) throws Exception {
        return Optional.empty();
    }
}
