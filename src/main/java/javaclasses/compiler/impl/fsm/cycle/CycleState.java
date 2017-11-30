package javaclasses.compiler.impl.fsm.cycle;

public enum CycleState {
    START,
    WHILE,
    OPENING_BRACKET,
    BOOLEAN_CONDITION,
    CLOSING_BRACKET,
    OPENING_BRACE,
    EXECUTION_SCOPE,
    CLOSING_BRACE,
    FINISH
}
