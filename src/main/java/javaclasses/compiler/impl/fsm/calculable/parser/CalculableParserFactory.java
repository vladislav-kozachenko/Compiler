package javaclasses.compiler.impl.fsm.calculable.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;
import javaclasses.compiler.impl.fsm.common.parser.ClosingBracketParser;
import javaclasses.compiler.impl.fsm.common.parser.FunctionCallParser;
import javaclasses.compiler.impl.fsm.common.parser.OpeningBracketParser;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.calculable.CalculableState.*;


public class CalculableParserFactory {

    private final Map<CalculableState, SourceCodeParser> parsers = new HashMap<CalculableState, SourceCodeParser>() {{
        put(NUMBER, new NumberParser());
        put(FUNCTION_CALL, new FunctionCallParser());
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
    }};


    public  SourceCodeParser getParser(CalculableState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
