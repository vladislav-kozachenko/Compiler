package javaclasses.compiler.impl.fsm.calculable.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.NumberCommand;

import java.text.DecimalFormat;
import java.text.ParsePosition;

public class NumberParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final DecimalFormat format = new DecimalFormat("0.0");
        final ParsePosition parsePosition = new ParsePosition(0);

        final Number number = format.parse(reader.getRemainingCode(), parsePosition);

        if (parsePosition.getErrorIndex() == -1) {

            final double doubleValue = number.doubleValue();
            output.addCommand(new NumberCommand(doubleValue));
            reader.incrementParsePosition(parsePosition.getIndex());

            return true;
        }

        return false;
    }
}
