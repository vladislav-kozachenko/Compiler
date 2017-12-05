package javaclasses.compiler;

import javaclasses.compiler.impl.executor.ExecutionContext;

public interface Command {
    void execute(ExecutionContext context) throws Exception;
}
