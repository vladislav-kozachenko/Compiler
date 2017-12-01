package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.OpeningBraceCommand;

import java.util.List;

public class OpeningBraceParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        String code = reader.getRemainingCode();

        if (code.startsWith("{")) {

            output.add(new OpeningBraceCommand());
            reader.incrementParsePosition(1);

            return true;
        }

        return false;
    }
}
