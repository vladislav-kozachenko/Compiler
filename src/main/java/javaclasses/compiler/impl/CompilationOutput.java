package javaclasses.compiler.impl;

import javaclasses.compiler.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompilationOutput {

    private final List<Command> algorithm;

    private final Set<String> variables;

    public CompilationOutput() {
        this.algorithm = new ArrayList<>();
        this.variables = new HashSet<>();
    }

    public void addCommand(Command command){
        algorithm.add(command);
    }

    public void defineVariable(String name){
        variables.add(name);
    }

    public List<Command> getCommandList(){
        return algorithm;
    }

    public Set<String> getVariables() {
        return variables;
    }
}
