package javaclasses.compiler;

import java.util.List;
import java.util.Optional;

public interface Compiler {

    List<Command> compile(String sourceCode) throws Exception;

    Optional execute(List<Command> executionScope) throws Exception;
}
