package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {

    public static final int DEFAULT_MAX_ARGUMENTS_NUMBER = 100;

    private final Map<String, Function> functions = new HashMap<String, Function>() {{
        put("max", new MaxFunction(2, DEFAULT_MAX_ARGUMENTS_NUMBER));
        put("min", new MinFunction(2, DEFAULT_MAX_ARGUMENTS_NUMBER));
        put("sum", new SumFunction(2, DEFAULT_MAX_ARGUMENTS_NUMBER));
        put("avg", new AverageFunction(2, DEFAULT_MAX_ARGUMENTS_NUMBER));
        put("log10", new Logarithm10Function(1, 1));
        put("pi", new PiFunction(0, 0));
        put("print", new PrintFunction(1, 1));
    }};

    public Function getFunction(String name){
        return functions.get(name);
    }

    public Set<String> getFunctionNames(){
        return functions.keySet();
    }

}
