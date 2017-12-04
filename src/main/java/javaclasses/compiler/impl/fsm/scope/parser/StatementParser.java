package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.StatementStartCommand;
import javaclasses.compiler.impl.fsm.statement.Statement;
import javaclasses.compiler.impl.fsm.statement.StatementState;

public class StatementParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (!code.isEmpty() && !code.startsWith("}") && !code.startsWith(";")) {
            output.addCommand(new StatementStartCommand());
            new Statement().start(StatementState.START, reader, output);
            return true;
        }

        return false;
    }
}
