package javaclasses.compiler.impl;

public interface BooleanBinaryOperator {

    /**
     * Evaluates atomic mathematical expression.
     * @return the result of mathematical operation proceeded on operands.
     */
    boolean evaluate(double leftOperand, double rightOperand);

}
