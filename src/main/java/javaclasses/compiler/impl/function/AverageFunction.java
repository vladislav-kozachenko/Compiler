package javaclasses.compiler.impl.function;


import javaclasses.compiler.impl.Function;

import java.util.List;
import java.util.Optional;

public class AverageFunction extends Function {

    public AverageFunction(int minArguments, int maxArguments) {
        super(minArguments, maxArguments);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {
        validateArgumentsNumber(args.size());
        Optional<Double> result = new SumFunction(2, Integer.MAX_VALUE).execute(args);
        return result.map(aDouble -> aDouble / args.size());
    }
}
