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

    abstract public Optional<Double> execute(List<Double> args) throws Exception;

    protected void validateArgumentsNumber(int argumentsNumber) throws Exception {
        if (argumentsNumber < minArguments || argumentsNumber > maxArguments) {
            throw new Exception("Wrong number of arguments.");
        }
    }

}
