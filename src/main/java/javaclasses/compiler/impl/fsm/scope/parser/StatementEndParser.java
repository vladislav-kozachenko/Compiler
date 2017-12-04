package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.StatementEndCommand;

import java.util.List;

public class StatementEndParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith(";") || code.startsWith("}")) {
            output.add(new StatementEndCommand());
            reader.incrementParsePosition(1);
            return true;
        }


        return false;
    }
}
