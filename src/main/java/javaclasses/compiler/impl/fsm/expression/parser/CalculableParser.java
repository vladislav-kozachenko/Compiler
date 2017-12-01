package javaclasses.compiler.impl.fsm.expression.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.calculable.Calculable;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;

import java.util.List;

public class CalculableParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (!code.isEmpty()){
            new Calculable().start(CalculableState.START, reader, output);
            return true;
        }

        return false;
    }
}
