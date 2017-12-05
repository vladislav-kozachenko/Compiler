package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class NumberCommand implements Command {

    private final double number;

    public NumberCommand(double number) {
        this.number = number;
    }

    @Override
    public void execute(ExecutionContext context) {
        context.getEvaluationContext().pushNumber(number);
    }
}
