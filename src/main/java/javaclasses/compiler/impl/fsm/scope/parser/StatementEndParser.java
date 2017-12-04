package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.StatementEndCommand;

public class StatementEndParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith(";") || code.startsWith("}")) {
            output.addCommand(new StatementEndCommand());
            reader.incrementParsePosition(1);
            return true;
        }


        return false;
    }
}
