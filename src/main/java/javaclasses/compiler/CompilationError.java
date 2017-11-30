package javaclasses.compiler;

public class CompilationError extends Exception {

    private final int errorPosition;

    public CompilationError(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public int getErrorPosition() {
        return errorPosition;
    }

}
