public class MultiplyOperator<T> implements AllOperator<T> {
    @Override
    public T operate(T input1, T input2) {
        return (T) Operator.MULTIPLY.operate((double)input1, (double)input2);
    }
}
