package javaclasses.compiler.impl.fsm.function.parser;

import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.FunctionCallNameCommand;
import javaclasses.compiler.impl.function.FunctionFactory;

public class FunctionNameParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();
        final FunctionFactory factory = new FunctionFactory();

        for (String functionName : factory.getFunctionNames()) {
            if (code.startsWith(functionName + "(")) {
                output.addCommand(new FunctionCallNameCommand(factory.getFunction(functionName)));
                reader.incrementParsePosition(functionName.length());
                return true;
            }
        }

        return false;

    }
}
