import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> resultList = new ArrayList<>();
        String exit = ""; //계산 종료 input
        String remove = ""; //결과값 배열 첫번째 값 제거 명령어?
        String inquiry = ""; //결과값 배열 전부 조회 명령어?

        int input1 = 0; //첫 번째 입력값
        int input2 = 0; //두 번째 입력값
        char operator = ' '; //연산자 입력값

        //exit입력시 반복 종료
        while(!exit.equals("exit")){
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            input1 = Integer.parseInt(br.readLine());

            System.out.print("두 번째 숫자를 입력하세요 : ");
            input2 = Integer.parseInt(br.readLine());

            System.out.print("연산자를 입력하세요 : ");
            operator = br.readLine().charAt(0);

            try{
                resultList = calculator.calculate(input1, input2, operator);
            }catch(AllException e){
                System.out.println(e.getMessage());
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            remove = br.readLine();

            //remove입력시 결과값 리스트에서 첫번째 값 제거
            if(remove.equals("remove")){
                resultList.remove(0);
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inquiry = br.readLine();

            //inquiry입력시 결과값 전부 조회
            if(inquiry.equals("inquiry")){
                for(int r : resultList){
                    System.out.println(r);
                }
            }

            System.out.println("enter any word to continue? (exit 입력 시 종료)");
            exit = br.readLine();
        }

    }
}