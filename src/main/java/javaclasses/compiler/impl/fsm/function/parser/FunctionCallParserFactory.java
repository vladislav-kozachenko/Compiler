package javaclasses.compiler.impl.fsm.function.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.common.parser.AcceptFinish;
import javaclasses.compiler.impl.fsm.common.parser.ClosingBracketParser;
import javaclasses.compiler.impl.fsm.common.parser.ExpressionParser;
import javaclasses.compiler.impl.fsm.common.parser.OpeningBracketParser;
import javaclasses.compiler.impl.fsm.function.FunctionCallState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.function.FunctionCallState.*;


public class FunctionCallParserFactory {

    private final Map<FunctionCallState, SourceCodeParser> parsers = new HashMap<FunctionCallState, SourceCodeParser>() {{
        put(FUNCTION_NAME, new FunctionNameParser());
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(EXPRESSION, new ExpressionParser());
        put(ARGUMENT_DELIMITER, new ArgumentDelimiterParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
        put(FINISH, new AcceptFinish());

    }};


    public  SourceCodeParser getParser(FunctionCallState state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
