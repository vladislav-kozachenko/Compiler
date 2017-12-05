package javaclasses.compiler.impl.executor;

import javaclasses.compiler.Command;
import javaclasses.compiler.impl.CompilationOutput;

import java.util.List;
import java.util.Optional;

public class Executor {

    public Optional execute(CompilationOutput input){
        final ExecutionContext globalContext = new ExecutionContext();
        List<Command> commands = input.getCommandList();

        for (Command command : commands) {
            command.execute(globalContext);
        }

        return Optional.empty();
    }

}
