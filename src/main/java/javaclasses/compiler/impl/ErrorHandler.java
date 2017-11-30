package javaclasses.compiler.impl;

import javaclasses.compiler.CompilationError;

public interface ErrorHandler {
    void raiseError(String message) throws CompilationError;
}
