package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;

public class WhileParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        final String code = reader.getRemainingCode();

        if (code.matches("^while\\(.*")) {
            reader.incrementParsePosition(5);
            return true;
        }

        return false;
    }
}
