package javaclasses.compiler.impl.fsm.common.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.ClosingBracketCommand;

import java.util.List;

public class ClosingBracketParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        String code = reader.getRemainingCode();

        if (code.startsWith(")")) {

            output.add(new ClosingBracketCommand());
            reader.incrementParsePosition(1);

            return true;
        }

        return false;
    }
}
