package javaclasses.compiler.impl.fsm.variable;

public enum VariableInitializationState {
    START,
    VARIABLE_NAME,
    ASSIGN,
    EXPRESSION,
    FINISH
}
