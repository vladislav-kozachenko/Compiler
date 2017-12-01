package javaclasses.compiler.impl.operator.math;

public class ExponentiationOperator extends AbstractBinaryOperator {

    ExponentiationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
