package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.ClosingBraceCommand;

public class ClosingBraceParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {
        String code = reader.getRemainingCode();

        if (code.startsWith("}")) {

            output.addCommand(new ClosingBraceCommand());

            return true;
        }

        return false;
    }
}
