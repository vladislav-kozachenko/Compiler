package javaclasses.compiler.impl.fsm.function.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.FunctionArgumentDelimiterCommand;

import java.util.List;

public class ArgumentDelimiterParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith(",")) {
            output.add(new FunctionArgumentDelimiterCommand());
            reader.incrementParsePosition(1);
            return true;
        }


        return false;
    }
}
