import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("첫 번째 숫자를 입력하세요 : ");
        int input1 = Integer.parseInt(br.readLine());

        System.out.println("두 번째 숫자를 입력하세요 : ");
        int input2 = Integer.parseInt(br.readLine());

        System.out.println("연산자를 입력하세요 : ");
        char operator = br.readLine().charAt(0);

    }
}