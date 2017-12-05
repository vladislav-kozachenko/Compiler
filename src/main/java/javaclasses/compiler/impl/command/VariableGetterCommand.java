package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class VariableGetterCommand implements Command {

    private final String variableName;

    public VariableGetterCommand(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void execute(ExecutionContext context) {
        context.getEvaluationContext().pushVariable(variableName);
    }
}
