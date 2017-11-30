package javaclasses.compiler.impl;

import javaclasses.compiler.CompilationError;

import java.util.List;
import java.util.Optional;

public abstract class Function {

    private int minArguments;
    private int maxArguments;

    public Function(int minArguments, int maxArguments) {
        this.minArguments = minArguments;
        this.maxArguments = maxArguments;
    }

    abstract public Optional<Double> execute(List<Double> args, ErrorHandler errorHandler) throws CompilationError;

    protected void validateArgumentsNumber(int argumentsNumber, ErrorHandler errorHandler) throws CompilationError {
        if (argumentsNumber < minArguments || argumentsNumber > maxArguments) {
            if (minArguments == maxArguments) {
                errorHandler.raiseError("Function requires " + minArguments + " arguments.");
            } else {
                errorHandler.raiseError(argumentsNumber
                        + " arguments is not allowed here. Use from "
                        + minArguments + " to "
                        + maxArguments + " arguments.");
            }
        }
    }

}
