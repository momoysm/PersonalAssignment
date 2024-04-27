import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String error = "";

        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int input1 = Integer.parseInt(br.readLine());

        System.out.print("두 번째 숫자를 입력하세요 : ");
        int input2 = Integer.parseInt(br.readLine());

        System.out.print("연산자를 입력하세요 : ");
        char operator = br.readLine().charAt(0);

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

        if(error.isEmpty()){
            System.out.println("결과 : " + result);
        }else{
            System.out.println(error);
        }

    }
}