package javaclasses.compiler.impl.fsm.expression.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.operator.math.BinaryOperatorFactory;

import java.util.List;

public class ExpressionFinishParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final BinaryOperatorFactory factory = new BinaryOperatorFactory();

        final String code = reader.getRemainingCode();

        for (String sign : factory.getOperatorSigns()) {
            if (code.startsWith(sign)) {
                return false;
            }
        }

        return true;
    }
}
