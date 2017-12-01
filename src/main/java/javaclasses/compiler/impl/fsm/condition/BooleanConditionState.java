package javaclasses.compiler.impl.fsm.condition;

public enum BooleanConditionState {
    START,
    LEFT_EXPRESSION,
    BOOLEAN_BINARY_OPERATOR,
    RIGHT_EXPRESSION,
    FINISH
}
