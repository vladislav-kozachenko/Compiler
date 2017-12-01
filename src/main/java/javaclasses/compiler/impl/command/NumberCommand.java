package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;

import java.util.Optional;

public class NumberCommand implements Command {

    private final double number;

    public NumberCommand(double number) {
        this.number = number;
    }

    @Override
    public Optional execute(Optional... args) {
        return Optional.empty();
    }
}
