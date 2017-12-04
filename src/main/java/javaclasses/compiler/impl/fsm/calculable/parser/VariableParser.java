package javaclasses.compiler.impl.fsm.calculable.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.VariableGetterCommand;

public class VariableParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        for (String variableName : output.getVariables()) {
            if (code.matches("^" + variableName + "\\W+.*")){
                output.addCommand(new VariableGetterCommand(variableName));
                reader.incrementParsePosition(variableName.length());
                return true;
            }
        }

        return false;
    }
}
