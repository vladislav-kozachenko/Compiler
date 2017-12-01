package javaclasses.compiler.impl.fsm.calculable.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.calculable.CalculableState.*;


public class CalculableParserFactory {

    private final Map<CalculableState, SourceCodeParser> parsers = new HashMap<CalculableState, SourceCodeParser>() {{
        put(NUMBER, new NumberParser());
    }};


    public  SourceCodeParser getParser(CalculableState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
