import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String exit = ""; //계산 종료 input
        String remove = ""; //결과값 배열 첫번째 값 제거 명령어?
        String inquiry = ""; //결과값 배열 전부 조회 명령어?

        double input1 = 0.0; //첫 번째 입력값
        double input2 = 0.0; //두 번째 입력값
        char operator = ' '; //연산자 입력값
        double radius = 0;

        try{
            //exit입력시 반복 종료
            while(!"exit".equals(exit)){

                System.out.println("연산 종류를 고르세요. (원의 넓이 : 1, 사칙연산 : 2)");
                int gubun = Integer.parseInt(br.readLine());

                if(gubun == 1){//원의 넓이
                    Calculator<Double> calculator = new CircleCalculator<>();

                    System.out.print("반지름을 입력하세요 : ");
                    radius = Double.parseDouble(br.readLine());

                    calculator.calculate(radius);

                    calculator.inquiryResultList();

                }else if(gubun == 2){//사칙연산
                    Calculator<Double> calculator = new ArithmeticCalculator<>();

                    System.out.print("첫 번째 숫자를 입력하세요 : ");
                    input1 = Double.parseDouble(br.readLine());

                    System.out.print("두 번째 숫자를 입력하세요 : ");
                    input2 = Double.parseDouble(br.readLine());

                    System.out.print("연산자를 입력하세요 : ");
                    operator = br.readLine().charAt(0);

                    calculator.calculate(input1, input2, operator);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    remove = br.readLine();

                    //remove입력시 결과값 리스트에서 첫번째 값 제거
                    if(remove.equals("remove")){
                        calculator.removeResultList();
                    }

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    inquiry = br.readLine();

                    calculator.outputResult();

                    //inquiry입력시 결과값 전부 조회
                    if(inquiry.equals("inquiry")){
                        calculator.inquiryResultList();
                    }
                }else{

                    System.out.println("해당하는 연산종류가 없습니다.");

                }

                System.out.println("enter any word to continue? (exit 입력 시 종료)");
                exit = br.readLine();
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}