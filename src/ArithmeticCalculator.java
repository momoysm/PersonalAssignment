import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator{

    private ArrayList<Integer> resultList;

    AddOperator addOperator;
    SubtractOperator subtractOperator;
    MultiplyOperator multiplyOperator;
    DivideOperator divideOperator;

    ArithmeticCalculator(){
        resultList = new ArrayList<>();
        addOperator = new AddOperator();
        subtractOperator = new SubtractOperator();
        multiplyOperator = new MultiplyOperator();
        divideOperator = new DivideOperator();
    }

    public ArrayList<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Integer> resultList) {
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

    public void calculate(int input1, int input2, char operator) throws AllException{

        int result = 0;
        String error = "";

        switch (operator) {
            case('+'):
                result = addOperator.operate(input1, input2);
                break;
            case('-'):
                result = subtractOperator.operate(input1, input2);
                break;
            case('*'):
                result = multiplyOperator.operate(input1, input2);
                break;
            case('/'):
                if(input2 == 0) {
                    error = "0으로는 나눌 수 없습니다.";
                }else{
                    result = divideOperator.operate(input1, input2);
                }
                break;
            default:
                error = "사용할 수 없는 연산자입니다.";
                break;
        }

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