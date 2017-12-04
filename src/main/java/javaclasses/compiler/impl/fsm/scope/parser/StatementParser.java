package javaclasses.compiler.impl.fsm.scope.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.statement.Statement;
import javaclasses.compiler.impl.fsm.statement.StatementState;

import java.util.List;

public class StatementParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (!code.isEmpty() && !code.startsWith("}") && !code.startsWith(";")) {
            new Statement().start(StatementState.START, reader, output);
            return true;
        }

        return false;
    }
}
