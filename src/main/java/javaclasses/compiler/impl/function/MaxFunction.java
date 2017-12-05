package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MaxFunction extends Function {

    public MaxFunction(int minArguments, int maxArguments) {
        super(minArguments, maxArguments);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {
        validateArgumentsNumber(args.size());
        return Optional.of(Collections.max(args));
    }
}
