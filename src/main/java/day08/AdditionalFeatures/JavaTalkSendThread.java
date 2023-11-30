package day08.AdditionalFeatures;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

// Thread 상속
public class JavaTalkSendThread extends Thread{
    Socket socket;

    public JavaTalkSendThread(Socket socket) {
        this.socket = socket;
    }

    // 보내는 run 메소드 생성
    @Override
    public void run() {
        // 여기서부터 보내는 코드
        OutputStream os = null;
        try {
            // 소켓에게 보낼거임
            os = socket.getOutputStream();
            // 보낼 내용을 쓸거임
            OutputStreamWriter osw = new OutputStreamWriter(os);
            // 보낼 내용을 성능좋게 쓸거임
            BufferedWriter bow = new BufferedWriter(osw);
            // 보낼 내용을 입력할 스캐너
            Scanner scTalk = new Scanner(System.in);

            // 보낼 내용을 입력할 코드를 무한 반복
            while (true) {
                // 스캐너로 입력한 내용을 talk에 저장할거임
                String talk = scTalk.nextLine();
                // 보낼 내용 출력
                bow.write(talk + "\n");
                bow.flush();
                // 여기까지 보내는 코드
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
