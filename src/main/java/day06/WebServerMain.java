package day06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerMain {
    public static void main(String[] args) {
        try {
            // 포트를 LISTEN 상태로 변경
            ServerSocket serverSocket = new ServerSocket(4321);
            // serverSocket.accept()는 클라이언트 쪽에서 new Socket()이 실행되어야 끝남
            Socket cs = serverSocket.accept();

            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = cs.getOutputStream();
            PrintStream ps = new PrintStream(os);

            String result = null;
            while( (result = br.readLine()) != null) {
                if(result.contains("html")) {
                    FileReader fr = null;

                    fr = new FileReader("c:\\test\\"+result.split(" ")[1].replace("/",""));

                    BufferedReader fbr = new BufferedReader(fr);
                    String total = "";
                    String r = null;
                    while(( r = fbr.readLine()) != null){
                        total = total + r;
                    }
                    System.out.println(total);

                    ps.println("HTTP/1.1 200 OK");
                    ps.println("Content-Length: "+ total.length());
                    ps.println("Content-Type: text/html");
                    ps.println();
                    ps.println(total);
                    ps.println();
                    break;
                }

            }






            serverSocket.close();
            cs.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
