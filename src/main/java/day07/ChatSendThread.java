package day07;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatSendThread extends Thread{
    Socket socket;

    // 스레드 생성자
    public ChatSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 여기서부터 보내는 코드

        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.print("서버에게 보낼 내용을 입력해주세요 : ");
                String chat = sc.nextLine();
                bow.write(chat + "\n");
                bow.flush();
                // 여기까지 보내는 코드

                // 이미지 전송 기능
                // 메시지를 보내는 클라이언트가 서버로 사진을 전송
                // 사진을 받은 서버가 다른 클라이언트에게 사진을 전송
                /*System.out.print("다른 클라이언트에게 보낼 이미지명을 입력해주세요 : ");
                String imageName = sc.nextLine();
                // 여기서부터 보내는 코드
                System.out.println("클라이언트가 입력한 " + imageName + " 파일을 보냅니다.");
                OutputStream os1 = cs.getOutputStream();*/


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
