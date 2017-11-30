package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.function.FunctionCall;
import javaclasses.compiler.impl.fsm.function.FunctionCallState;
import javaclasses.compiler.impl.function.FunctionFactory;

import java.util.List;

public class FunctionCallParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();
        final FunctionFactory factory = new FunctionFactory();

        for (String functionName : factory.getFunctionNames()) {
            if (code.matches("^" + functionName + "\\(")) {
                new FunctionCall().start(FunctionCallState.START, reader, output);
                return true;
            }
        }

        return false;
    }
}
