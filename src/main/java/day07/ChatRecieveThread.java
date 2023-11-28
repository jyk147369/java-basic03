package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatRecieveThread extends Thread{
    Socket socket;

    public ChatRecieveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 여기서부터 받는 코드

        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);

            while(true){
                String chat = bir.readLine();
                // readLine : 글자를 읽을때 한줄씩 읽는 메소드
                System.out.println(chat);
                // 여기까지 받는 코드

                // 기능추가
                //                if () {
                //
                //                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
