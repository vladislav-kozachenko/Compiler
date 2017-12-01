package javaclasses.compiler.impl.fsm.condition;

public enum BooleanConditionState {
    START,
    BOOLEAN_BINARY_OPERATOR,
    EXPRESSION,
    FINISH
}
