package day08.AdditionalFeatures;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class JavaTalkClientMain {

    public static void main(String[] args) {
        // 접속할 서버의 ip와 포트번호
        int port = 7972;
        String ip = "192.168.0.124";

        try {
            // 서버로 접속하는 코드
            // 클라이언트 소켓 생성
            // 서버가 실행되어 있어야 제대로 실행됨
            System.out.println("서버에 연결중입니다.");
            Socket clientSocket = new Socket(ip,port);
            System.out.println("서버와 연결되었습니다.");
            System.out.println();

            // 보내는 코드
            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);

            // ID 생성
            Scanner scId = new Scanner(System.in);
            System.out.print("사용할 ID를 입력해주세요 : ");
            String id = scId.nextLine();

            bow.write(id + "\n");
            bow.flush();

            System.out.println("채팅을 시작합니다.");
            System.out.println();

            // 서버와 연결되면 송신 스레드와 수신 스레드를 생성하고 실행하여 채팅한다.

            // 채팅 송신 스레드 생성
            Thread javaTalkSendThread = new JavaTalkSendThread(clientSocket);
            // 채팅 송신 스레드 실행
            javaTalkSendThread.start();

            // 채팅 수신 스레드 생성
            Thread javaTalkRecieveThread = new JavaTalkRecieveThread(clientSocket);
            // 채팅 수신 스레드 실행
            javaTalkRecieveThread.start();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
