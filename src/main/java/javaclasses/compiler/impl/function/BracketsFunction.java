package javaclasses.compiler.impl.function;


import javaclasses.compiler.impl.Function;

import java.util.List;
import java.util.Optional;

public class BracketsFunction extends Function {

    public BracketsFunction() {
        super(1, 1);
    }

    @Override
    public Optional<Double> execute(List<Double> args) throws Exception {
        if (args.size() != 1){
            throw new Exception("Argument separators are forbidden in a common brackets.");
        }
        return Optional.of(args.get(0));
    }
}
