package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.BinaryOperator;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class BinaryOperatorCommand implements Command {

    private BinaryOperator operator;

    public BinaryOperatorCommand(BinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public void execute(ExecutionContext context) {

    }
}
