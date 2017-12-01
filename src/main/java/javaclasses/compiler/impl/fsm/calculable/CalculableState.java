package javaclasses.compiler.impl.fsm.calculable;

public enum CalculableState {
    START,
    NUMBER,
    FUNCTION_CALL,
    OPENING_BRACKET,
    EXPRESSION,
    CLOSING_BRACKET,
    FINISH
}
