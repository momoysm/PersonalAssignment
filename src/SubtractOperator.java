public class SubtractOperator<T> implements AllOperator<T> {
    @Override
    public T operate(T input1, T input2) {
        T operate = (T) Operator.MINUS.operate((double) input1, (double) input2);
        return operate;
    }
}
