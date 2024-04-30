import java.util.ArrayList;

public class Calculator {

    private ArrayList<Integer> resultList;
    private ArrayList<Double> areaList;

    public Calculator(){
        this.resultList = new ArrayList<>();
        this.areaList = new ArrayList<>();
    }

    //getter setter가 더 이상 사용하지 않으므로 삭제
    /*public ArrayList<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Integer> resultList) {
        this.resultList = resultList;
    }*/

    public void removeResultList(int index) {//저장된 사칙연산 결과 중 첫 번째 삭제
        this.resultList.remove(0);
    }

    public void inquiryResultList() {//저장된 사칙연산 결과를 전체 조회
        System.out.println("전체 : " + this.resultList);
    }

    public void inquiryAreaList() {//저장된 원의 넓이를 전체 조회
        System.out.println("전체 : " + this.areaList);
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

    public void calculateCircleArea(double radius) throws AllException {
        String error = "";
        double area = Math.PI * radius * radius; //static, final 대신 Math.PI를 써서 파이 생성

        if(radius < 0){
            error = "반지름이 0보다 작을 수 없습니다.";
        }

        try{
            if(error.isEmpty()) {
                System.out.println("원의 넓이 : " + area);
                areaList.add(area);
            }else{
                throw new AllException(error);
            }
        }catch(AllException e){
            System.out.println(e.getMessage());
        }


    }
}
