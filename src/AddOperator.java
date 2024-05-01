public class AddOperator implements AllOperator {
    public int operate(int input1, int input2) {
        return Operator.PLUS.operate(input1, input2);
    }
}
