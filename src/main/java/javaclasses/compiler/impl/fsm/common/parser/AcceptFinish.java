package javaclasses.compiler.impl.fsm.common.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.command.NumberCommand;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.List;

public class AcceptFinish implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        return true;
    }
}
