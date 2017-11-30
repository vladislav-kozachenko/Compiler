package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {
    private final Map<String, Function> functions = new HashMap<String, Function>() {{
    }};

    public Function getFunction(String name){
        return functions.get(name);
    }

    public Set<String> getFunctionNames(){
        return functions.keySet();
    }

}
