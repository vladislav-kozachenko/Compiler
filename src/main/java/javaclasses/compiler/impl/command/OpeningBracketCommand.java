package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;

import java.util.Optional;

public class OpeningBracketCommand implements Command {
    @Override
    public Optional execute(Optional... args) {
        return Optional.empty();
    }
}
