package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.CompilationOutput;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.cycle.Cycle;
import javaclasses.compiler.impl.fsm.cycle.CycleState;

import java.util.List;

public class CycleParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, CompilationOutput output) throws CompilationError {

        final String code = reader.getRemainingCode();

        if (code.matches("^while.*")) {
            new Cycle().start(CycleState.START, reader, output);
            return true;
        }

        return false;
    }
}
