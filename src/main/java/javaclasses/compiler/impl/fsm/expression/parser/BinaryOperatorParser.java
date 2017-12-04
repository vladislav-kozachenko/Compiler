package javaclasses.compiler.impl.fsm.expression.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.BinaryOperatorCommand;
import javaclasses.compiler.impl.operator.math.BinaryOperatorFactory;

public class BinaryOperatorParser implements SourceCodeParser {

    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final BinaryOperatorFactory factory = new BinaryOperatorFactory();

        final String expression = reader.getRemainingCode();

        for (String sign : factory.getOperatorSigns()) {
            if (expression.startsWith(sign)) {

                output.addCommand(new BinaryOperatorCommand(factory.getBinaryOperator(sign)));
                reader.incrementParsePosition(sign.length());

                return true;
            }
        }

        return false;
    }

}
