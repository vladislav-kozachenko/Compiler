package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.BinaryOperator;
import javaclasses.compiler.impl.Function;

import java.util.Optional;

public class FunctionCallNameCommand implements Command {

    private Function function;

    public FunctionCallNameCommand(Function function) {
        this.function = function;
    }

    @Override
    public Optional execute(Optional... args) {
        return Optional.empty();
    }
}
