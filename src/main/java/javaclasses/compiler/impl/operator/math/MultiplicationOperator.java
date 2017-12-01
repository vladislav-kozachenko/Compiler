package javaclasses.compiler.impl.operator.math;

public class MultiplicationOperator extends AbstractBinaryOperator {

    MultiplicationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
