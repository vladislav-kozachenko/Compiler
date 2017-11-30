package javaclasses.compiler;

import java.util.Optional;

public interface Command {
    Optional execute(Optional... args);
}
