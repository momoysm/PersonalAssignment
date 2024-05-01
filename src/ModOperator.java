public class ModOperator<T> implements AllOperator<T> {
    public T operate(T input1, T input2) {
        return (T) Operator.MOD.operate((double)input1, (double)input2);
    }
}