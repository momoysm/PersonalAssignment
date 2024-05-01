import java.util.ArrayList;

public class CircleCalculator<T> extends Calculator<T>{

    private ArrayList<Double> areaList;

    public CircleCalculator() {
        areaList = new ArrayList<>();
    }

    public ArrayList<Double> getAreaList(){
        return areaList;
    }

    public void setResultList(ArrayList<Double> resultList) {
        areaList = resultList;
    }

    @Override
    public void removeResultList() {
        areaList.remove(0);
    }

    @Override
    public void inquiryResultList() {
        System.out.println("전체 결과 : "  + areaList);
    }

    @Override
    public void calculate(double radius) {
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

    @Override
    public void calculate(T input1, T input2, char operator) {
        throw new AllException("원의 넓이 계산기입니다.");
    }

}
