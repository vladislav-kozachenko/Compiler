package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;

public class FinishParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        return code.startsWith(";") || code.startsWith("}") || code.isEmpty();

    }
}
