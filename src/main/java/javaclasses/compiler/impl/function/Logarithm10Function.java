package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.List;
import java.util.Optional;

public class Logarithm10Function extends Function {

    public Logarithm10Function(int minArguments, int maxArguments) {
        super(minArguments, maxArguments);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {
        validateArgumentsNumber(args.size());
        return Optional.of(Math.log10(args.get(0)));
    }
}
