package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.BooleanBinaryOperator;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class BooleanBinaryOperatorCommand implements Command {

    private BooleanBinaryOperator operator;

    public BooleanBinaryOperatorCommand(BooleanBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public void execute(ExecutionContext context) {

    }
}
