package javaclasses.compiler.impl.fsm.common.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.OpeningBracketCommand;

public class OpeningBracketParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {
        String code = reader.getRemainingCode();

        if (code.startsWith("(")) {

            output.addCommand(new OpeningBracketCommand());
            reader.incrementParsePosition(1);

            return true;
        }

        return false;
    }
}
