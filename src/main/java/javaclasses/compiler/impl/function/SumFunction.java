package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.List;
import java.util.Optional;

public class SumFunction extends Function {

    public SumFunction(int minArguments, int maxArguments) {
        super(minArguments, maxArguments);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {

        validateArgumentsNumber(args.size());

        double result = 0;
        for (double value: args) {
            result += value;
        }
        return Optional.of(result);
    }
}
