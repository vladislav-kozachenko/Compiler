package javaclasses.compiler.impl.fsm.function.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.FunctionCallNameCommand;
import javaclasses.compiler.impl.fsm.function.FunctionCall;
import javaclasses.compiler.impl.fsm.function.FunctionCallState;
import javaclasses.compiler.impl.function.FunctionFactory;

import java.util.List;

public class FunctionNameParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();
        final FunctionFactory factory = new FunctionFactory();

        for (String functionName : factory.getFunctionNames()) {
            if (code.matches("^" + functionName + "\\(")) {
                output.add(new FunctionCallNameCommand(factory.getFunction(functionName)));
                reader.incrementParsePosition(functionName.length());
                return true;
            }
        }

        return false;

    }
}
