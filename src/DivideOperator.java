public class DivideOperator<T> implements AllOperator<T> {
    public T operate(T input1, T input2) {
        return (T) Operator.DIVIDE.operate((double)input1, (double)input2);
    }
}
