package day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketMain {
    public static void main(String[] args) {
        try {
            // 클라이언트가 실행이 되어야 출력
            // 랜카드를 통해 연결됨
            // 서버로 통하는 코드
            // 서버로 접속하는 코드, 서버가 실행되어 있어야 제대로 실행됨
            Socket clientSocket = new Socket("192.168.0.124", 9999);
            OutputStream clientSocketOutputStream = clientSocket.getOutputStream();
            clientSocketOutputStream.write(100);

            // cis.read()는 서버 쪽 쪽에서 cos.write()가 실행되어야 끝남
            InputStream clientSocketInputStream = clientSocket.getInputStream();
            int num = clientSocketInputStream.read();
            System.out.println(num);
            
            clientSocket.close();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
 }
