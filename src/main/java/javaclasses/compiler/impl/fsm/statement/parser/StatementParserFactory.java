package javaclasses.compiler.impl.fsm.statement.parser;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.ParserFactory;
import javaclasses.compiler.impl.fsm.common.parser.AcceptFinish;
import javaclasses.compiler.impl.fsm.common.parser.FunctionCallParser;
import javaclasses.compiler.impl.fsm.statement.StatementState;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.compiler.impl.fsm.statement.StatementState.*;


public class StatementParserFactory extends ParserFactory<StatementState> {

    public StatementParserFactory() {
        parsers = new HashMap<StatementState, SourceCodeParser>() {{
            put(VARIABLE_INITIALIZATION, new VariableInitializationParser());
            put(FUNCTION_CALL, new FunctionCallParser());
            put(CYCLE, new CycleParser());
            put(FINISH, new AcceptFinish());
        }};
    }

}
