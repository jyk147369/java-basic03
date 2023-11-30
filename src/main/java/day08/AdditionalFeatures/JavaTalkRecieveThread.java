package day08.AdditionalFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class JavaTalkRecieveThread extends Thread{
    Socket socket;

    public JavaTalkRecieveThread(Socket socket) {
        this.socket = socket;
    }

    // 받는 run 메소드 생성
    @Override
    public void run() {
        // 여기서부터 받는 코드
        InputStream is = null;
        try {
            // 소켓이 주는 것을 받을거임
            is = socket.getInputStream();
            // 주는 것을 읽을거임
            InputStreamReader isr = new InputStreamReader(is);
            // 주는 것을 성능좋게 읽을거임
            BufferedReader bir = new BufferedReader(isr);

            // 한 줄씩 계속 출력
            // 무한 반복
            while(true){
                // 한 줄씩 읽어서 talk에 저장할거임
                String talk = bir.readLine();
                // talk을 출력
                System.out.println(socket + "님이 입력한 채팅 : " + talk);
                // 여기까지 받는 코드
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
