package javaclasses.compiler.impl;

public interface BinaryOperator extends Comparable<BinaryOperator> {

    /**
     * Evaluates atomic mathematical expression.
     * @return the result of mathematical operation proceeded on operands.
     */
    double evaluate(double leftOperand, double rightOperand);

}
