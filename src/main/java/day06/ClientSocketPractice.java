package day06;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketPractice {
    public static void main(String[] args) throws IOException {
        // 서버와 통신하기 위한 소켓을 생성
        // 포트번호는 5678
        Socket client = new Socket("192.168.0.124", 5678);

        // 서버로부터 전송된 스트림을 읽기위한 핸들러를 얻는다.
        Scanner scanner = new Scanner(client.getInputStream());

        // 전송되어 온 스트림을 한줄씩 읽는다.
        String str = scanner.nextLine();

        // 전송되어 온 스트링을 출력한다.
        System.out.println(str);

        // 연결을 닫는다.
        scanner.close();
        client.close();

    }
}
