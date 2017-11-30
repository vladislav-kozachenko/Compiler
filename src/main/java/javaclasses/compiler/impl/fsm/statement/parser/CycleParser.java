package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;

import java.util.List;

public class CycleParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.matches("^while")) {
            new Cycle().start(CycleState.START, reader, output);
            return true;
        }


        return false;
    }
}
