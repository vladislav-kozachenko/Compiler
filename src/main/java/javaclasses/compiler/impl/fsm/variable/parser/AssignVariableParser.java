package javaclasses.compiler.impl.fsm.variable.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.AssignCommand;

import java.util.List;

public class AssignVariableParser implements javaclasses.compiler.impl.SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith("=")) {
            output.add(new AssignCommand());
            reader.incrementParsePosition(1);
            return true;
        }

        return false;
    }
}
