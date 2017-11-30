package javaclasses.compiler.impl;

public class SourceCodeReader {

    private final String sourceCode;
    private int parsePosition;

    public SourceCodeReader(String sourceCode) {
        this.sourceCode = sourceCode;
        this.parsePosition = 0;
    }

    /**
     * Checks if the parsing pointer reached end of source code.
     * @return true if the pointer is on the end of source code.
     */
    public boolean endOfExpression() {
        return parsePosition >= sourceCode.length();
    }

    public int getParsePosition() {
        return parsePosition;
    }

    /**
     * Moves pointer right.
     * @param value used for moving on inputted number.
     */
    public void incrementParsePosition(int value) {
        parsePosition += value;
    }

    /**
     * Creates new string from the next token to the end of string. Skips the whitespaces.
     * @return substring from current parsing position to end of source code.
     */
    public String getRemainingCode() {
        while (!endOfExpression()
                && Character.isWhitespace(sourceCode.charAt(parsePosition))){
            parsePosition++;
        }
        return sourceCode.substring(parsePosition);
    }


}
