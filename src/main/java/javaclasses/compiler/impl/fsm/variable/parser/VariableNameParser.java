package javaclasses.compiler.impl.fsm.variable.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.DefineVariableCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableNameParser implements javaclasses.compiler.impl.SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();
        final Pattern pattern = Pattern.compile("^\\w+(?=\\s*=)");
        final Matcher matcher = pattern.matcher(code);

        if (matcher.find()) {
            final String variableName = matcher.group();
            output.addCommand(new DefineVariableCommand(variableName));
            reader.incrementParsePosition(variableName.length());
            return true;
        }

        return false;
    }
}
