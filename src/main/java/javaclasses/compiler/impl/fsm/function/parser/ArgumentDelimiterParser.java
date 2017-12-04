package javaclasses.compiler.impl.fsm.function.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.FunctionArgumentDelimiterCommand;

public class ArgumentDelimiterParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith(",")) {
            output.addCommand(new FunctionArgumentDelimiterCommand());
            reader.incrementParsePosition(1);
            return true;
        }


        return false;
    }
}
