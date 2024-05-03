public class AddOperator<T> implements AllOperator<T> {
    @Override
    public T operate(T input1, T input2) {
        T operate = (T) Operator.PLUS.operate((double) input1, (double) input2);
        return operate;
    }
}
