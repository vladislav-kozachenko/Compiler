package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.ClosingBraceCommand;

import java.util.List;

public class ClosingBraceParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        String code = reader.getRemainingCode();

        if (code.startsWith("}")) {

            output.add(new ClosingBraceCommand());

            return true;
        }

        return false;
    }
}
