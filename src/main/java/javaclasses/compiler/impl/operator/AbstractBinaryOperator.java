package javaclasses.compiler.impl.operator;

import javaclasses.compiler.impl.BinaryOperator;

/**
 * Represents abstract mathematical operator which considers priority of operators.
 */
public abstract class AbstractBinaryOperator implements BinaryOperator, Comparable<BinaryOperator> {

    enum Priority {
        LOW, MEDIUM, HIGH
    }

    private final Priority priority;

    /**
     * Creates instance of operator and set its priority.
     */
    AbstractBinaryOperator(Priority priority) {
        this.priority = priority;
    }

    /**
     * Compares current operator with another using their priority.
     * @param operator operator which may be compared with the current one.
     * @return 0 if priorities is the same,
     * integer > 0 if the first operator is more priority,
     * integer < 0 if the first operator is less priority.
     */
    @Override
    public int compareTo(BinaryOperator operator) {
        return this.priority.compareTo(((AbstractBinaryOperator)operator).priority);
    }
}
