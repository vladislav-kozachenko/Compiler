package javaclasses.compiler.impl.function;

import javaclasses.compiler.impl.Function;

import java.util.List;
import java.util.Optional;

public class PrintFunction extends Function {

    public PrintFunction(int minArguments, int maxArguments) {
        super(minArguments, maxArguments);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {
        validateArgumentsNumber(args.size());
        System.out.println(args.get(0));

        return Optional.empty();
    }
}
