package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.Command;
import javaclasses.compiler.CompilationError;
import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.SourceCodeReader;
import javaclasses.compiler.impl.fsm.condition.BooleanCondition;
import javaclasses.compiler.impl.fsm.condition.BooleanConditionState;

import java.util.List;

public class BooleanConditionParser implements SourceCodeParser {
    @Override
    public boolean parse(SourceCodeReader reader, List<Command> output) throws CompilationError {
        final String code = reader.getRemainingCode();

        if (!code.isEmpty()) {
            new BooleanCondition().start(BooleanConditionState.START, reader, output);
            return true;
        }

        return false;
    }

}
