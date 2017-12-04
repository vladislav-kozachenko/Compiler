package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.variable.VariableInitialization;
import javaclasses.compiler.impl.fsm.variable.VariableInitializationState;

import java.util.List;

public class VariableInitializationParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.matches("^\\w+\\s*=.*")) {
            new VariableInitialization().start(VariableInitializationState.START, reader, output);
            return true;
        }

        return false;
    }
}
