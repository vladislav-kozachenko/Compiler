package javaclasses.compiler.impl.fsm.common.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.expression.Expression;
import javaclasses.compiler.impl.fsm.expression.ExpressionState;

import java.util.List;

public class ExpressionParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (!code.isEmpty()) {
            new Expression().start(ExpressionState.START, reader, output);
            return true;
        }

        return false;
    }
}
