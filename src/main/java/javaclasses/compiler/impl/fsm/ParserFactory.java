package javaclasses.compiler.impl.fsm;

import javaclasses.compiler.impl.SourceCodeParser;
import javaclasses.compiler.impl.fsm.calculable.CalculableState;

import java.util.Map;

public abstract class ParserFactory<State extends Enum> {

    protected Map<State, SourceCodeParser> parsers;

    public  SourceCodeParser getParser(State state) {
        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }

}
