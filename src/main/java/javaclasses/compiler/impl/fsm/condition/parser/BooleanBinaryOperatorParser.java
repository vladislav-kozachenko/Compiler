package javaclasses.compiler.impl.fsm.condition.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.BooleanBinaryOperatorCommand;
import javaclasses.compiler.impl.operator.bool.BooleanBinaryOperatorFactory;

import java.util.List;

public class BooleanBinaryOperatorParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final BooleanBinaryOperatorFactory factory = new BooleanBinaryOperatorFactory();

        final String expression = reader.getRemainingCode();

        for (String sign : factory.getBooleanOperatorSigns()) {
            if (expression.startsWith(sign)) {

                output.add(new BooleanBinaryOperatorCommand(factory.getBooleanBinaryOperator(sign)));
                reader.incrementParsePosition(sign.length());

                return true;
            }
        }

        return false;
    }
}
