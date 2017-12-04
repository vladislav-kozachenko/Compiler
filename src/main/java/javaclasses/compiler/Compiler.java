package javaclasses.compiler;

import javaclasses.compiler.impl.CompilationOutput;

import java.util.List;
import java.util.Optional;

public interface Compiler {

    CompilationOutput compile(String sourceCode) throws Exception;

    Optional execute(CompilationOutput executionScope) throws Exception;
}
