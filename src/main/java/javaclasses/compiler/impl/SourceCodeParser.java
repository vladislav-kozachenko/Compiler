package javaclasses.compiler.impl;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;

import java.util.List;

/**
 * Represents parser for mathematical expression.
 */
public interface SourceCodeParser {

    /**
     * Parses next token in expression.
     * @param reader is the expression reader which may be parsed.
     * @param output is the output where parsed command must be saved.
     * @return true if parsing was successful.
     */
    boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError;
}
