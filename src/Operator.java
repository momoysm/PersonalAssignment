import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (input1, input2) -> input1 + input2),
    MINUS("-", (input1, input2) -> input1 - input2),
    MULTIPLY("*", (input1, input2) -> input1 * input2),
    DIVIDE("/", (input1, input2) -> input1 / input2),
    MOD("%", (input1, input2) -> input1 % input2);

    private String symbol;
    private BiFunction<Double, Double, Double> expression;

    Operator(String symbol, BiFunction<Double, Double, Double> expression){
        this.symbol = symbol;
        this.expression = expression;
    }

    public Double operate(double input1, double input2){
        return expression.apply(input1, input2);
    }
}
