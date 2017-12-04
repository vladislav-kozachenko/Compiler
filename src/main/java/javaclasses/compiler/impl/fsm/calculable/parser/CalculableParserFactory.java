package javaclasses.compiler.impl.fsm.calculable.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.ParserFactory;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;
import javaclasses.compiler.impl.fsm.common.parser.*;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.calculable.CalculableState.*;


public class CalculableParserFactory extends ParserFactory<CalculableState>{

    public CalculableParserFactory() {
        parsers = new HashMap<CalculableState, SourceCodeParser>() {{
            put(NUMBER, new NumberParser());
            put(VARIABLE, new VariableParser());
            put(FUNCTION_CALL, new FunctionCallParser());
            put(OPENING_BRACKET, new OpeningBracketParser());
            put(CLOSING_BRACKET, new ClosingBracketParser());
            put(EXPRESSION, new ExpressionParser());
            put(FINISH, new AcceptFinish());
        }};
    }


}
