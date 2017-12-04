package javaclasses.compiler.impl.fsm.variable.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.AssignCommand;

public class AssignVariableParser implements javaclasses.compiler.impl.SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.startsWith("=")) {
            output.addCommand(new AssignCommand());
            reader.incrementParsePosition(1);
            return true;
        }

        return false;
    }
}
