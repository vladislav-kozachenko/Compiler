package javaclasses.compiler.impl.fsm.condition.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.ParserFactory;
import javaclasses.compiler.impl.fsm.common.parser.AcceptFinish;
import javaclasses.compiler.impl.fsm.common.parser.ExpressionParser;
import javaclasses.compiler.impl.fsm.condition.BooleanConditionState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.condition.BooleanConditionState.*;


public class BooleanConditionParserFactory extends ParserFactory<BooleanConditionState> {

    public BooleanConditionParserFactory() {
        parsers = new HashMap<BooleanConditionState, SourceCodeParser>() {{
            put(LEFT_EXPRESSION, new ExpressionParser());
            put(RIGHT_EXPRESSION, new ExpressionParser());
            put(BOOLEAN_BINARY_OPERATOR, new BooleanBinaryOperatorParser());
            put(FINISH, new AcceptFinish());
        }};
    }


}
