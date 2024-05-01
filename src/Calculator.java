import java.util.ArrayList;

public abstract class Calculator<T> {

    public abstract void removeResultList();

    public abstract void inquiryResultList();

    public abstract void calculate(double radius);

    public abstract void calculate(T input1, T input2, char operator);

}
