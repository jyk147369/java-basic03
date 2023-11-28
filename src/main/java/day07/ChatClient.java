package day07;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // 서버로 접속하는 코드
            // 소켓 생성
            Socket socket = new Socket("192.168.45.38", 9998);
            System.out.println("서버와 연결되었습니다.");

            // 메시지 송신 스레드 생성
            Thread chatSendThread = new ChatSendThread(socket);
            chatSendThread.start();

            // 메시지 수신 스레드 생성
            Thread chatRecieveThread = new ChatRecieveThread(socket);
            chatRecieveThread.start();

            while (true) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
