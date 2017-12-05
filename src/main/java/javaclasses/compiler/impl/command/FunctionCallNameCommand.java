package javaclasses.compiler.impl.command;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.Function;
import javaclasses.compiler.impl.executor.ExecutionContext;

import java.util.Optional;

public class FunctionCallNameCommand implements Command {

    private Function function;

    public FunctionCallNameCommand(Function function) {
        this.function = function;
    }

    @Override
    public void execute(ExecutionContext context) {
        context.getEvaluationContext().pushFunction(function);
    }
}
