package javaclasses.compiler.impl.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExecutionContext {

    private final Map<String, Double> variables = new HashMap<>();

    private EvaluationContext evaluationContext;

    public EvaluationContext getEvaluationContext() {
        return evaluationContext;
    }

    public void newEvaluationContext(){
        evaluationContext = new EvaluationContext(variables);
    }
}
