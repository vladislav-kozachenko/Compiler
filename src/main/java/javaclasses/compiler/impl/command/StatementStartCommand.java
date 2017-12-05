package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class StatementStartCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        context.newEvaluationContext();
    }
}
