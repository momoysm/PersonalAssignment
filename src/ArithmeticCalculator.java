import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticCalculator<T> extends Calculator<T>{

    private ArrayList<T> resultList;

    AllOperator allOperator;

    ArithmeticCalculator(){
        resultList = new ArrayList<>();
    }

    @Override
    public void outputResult(){
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 최소 수치를 입력하세요 : ");
        double minNumber = sc.nextDouble();

        resultList.forEach(e -> {
            if((double)e > minNumber){
                System.out.println(e);
            }
        });
    }

    public ArrayList<T> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<T> resultList) {
        this.resultList = resultList;
    }

    @Override
    public void removeResultList() {//저장된 사칙연산 결과 중 첫 번째 삭제
        resultList.remove(0);
    }

    @Override
    public void inquiryResultList() {
        System.out.println("전체 결과 : "  + resultList);
    }

    @Override
    public void calculate(double radius) {
        throw new AllException("사칙연산 계산기입니다.");
    }

    @Override
    public void calculate(T input1, T input2, char operator){

        T result;
        String error = "";

        try{
            switch (operator) {
                case('+') -> allOperator = new AddOperator();

                case('-') -> allOperator = new SubtractOperator();

                case('*') -> allOperator = new MultiplyOperator();

                case('/') -> allOperator = new DivideOperator();

                default -> error = "사용할 수 없는 연산자입니다.";
            }
        }catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }

        result = (T) allOperator.operate(input1, input2);

        try{
            if(error.isEmpty()){
                System.out.println("결과 : " + result);
                resultList.add(result);
            }else{
                throw new AllException(error); //error가 있으면 error출력
            }
        }catch(AllException e){
            System.out.println(e.getMessage());
        }

    }
}
