package javaclasses.compiler.impl.fsm.cycle.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.ParserFactory;
import javaclasses.compiler.impl.fsm.calculable.parser.NumberParser;
import javaclasses.compiler.impl.fsm.common.parser.*;
import javaclasses.compiler.impl.fsm.cycle.CycleState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.cycle.CycleState.*;


public class CycleParserFactory extends ParserFactory<CycleState>{

    public CycleParserFactory() {
        parsers = new HashMap<CycleState, SourceCodeParser>() {{
            put(WHILE, new WhileParser());
            put(OPENING_BRACKET, new OpeningBracketParser());
            put(BOOLEAN_CONDITION, new BooleanConditionParser());
            put(CLOSING_BRACKET, new ClosingBracketParser());
            put(OPENING_BRACE, new OpeningBraceParser());
            put(EXECUTION_SCOPE, new ExecutionScopeParser());
            put(CLOSING_BRACE, new ClosingBraceParser());
            put(FINISH, new AcceptFinish());
        }};
    }


}
