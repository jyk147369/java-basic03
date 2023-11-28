package day06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientMain {
    public static void main(String[] args) {
        try {
            // 서버로 접속하는 코드, 서버가 실행되어 있어야 제대로 실행 됨
            Socket cs = new Socket("192.168.0.124", 9876);

            // 받는거
            // 여기서부터 받는 코드
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            String data = bir.readLine();
            System.out.println(data);
            // 여기까지 받는 코드
            
            // 보내는 거
            // 여기서부터 보내는 코드
            OutputStream os = cs.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);

            Scanner sc = new Scanner(System.in);
            System.out.print("서버에게 보낼 내용을 입력해주세요 : ");
            String message = sc.nextLine();

            bow.write(message + "\n");
            bow.flush();
            // 여기까지 보내는 코드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
