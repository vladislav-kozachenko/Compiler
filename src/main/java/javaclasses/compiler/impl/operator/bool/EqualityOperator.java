package javaclasses.compiler.impl.operator.bool;

import javaclasses.compiler.impl.BooleanBinaryOperator;

public class EqualityOperator implements BooleanBinaryOperator {
    @Override
    public boolean evaluate(double leftOperand, double rightOperand) {
        return leftOperand == rightOperand;
    }
}
