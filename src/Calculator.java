import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList = new ArrayList<Integer>(); //결과값 저장 List

    public ArrayList<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Integer> resultList) {
        this.resultList = resultList;
    }

    public void calculate(int input1, int input2, char operator) throws AllException{

        int result = 0;
        String error = "";

        switch (operator) {
            case('+'):
                result = input1 + input2;
                break;
            case('-'):
                result = input1 - input2;
                break;
            case('*'):
                result = input1 * input2;
                break;
            case('/'):
                if(input2 == 0) {
                    error = "0으로는 나눌 수 없습니다.";
                }else{
                    result = input1 / input2;
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
