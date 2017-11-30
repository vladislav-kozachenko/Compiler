package javaclasses.compiler.impl.fsm.function;

public enum FunctionCallState {

    START,
    FUNCTION_NAME,
    OPENING_BRACKET,
    EXPRESSION,
    ARGUMENT_DELIMITER,
    CLOSING_BRACKET,
    FINISH


}
