package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;

import java.util.Optional;

public class VariableGetterCommand implements Command {

    private final String variableName;

    public VariableGetterCommand(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Optional execute(Optional... args) {
        return Optional.empty();
    }
}
