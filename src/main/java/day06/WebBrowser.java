package day06;

import java.io.*;
import java.net.Socket;

public class WebBrowser {
    public static void main(String[] args) throws IOException {
        // 서버로 접속하는 코드, 서버가 실행되어 있어야 제대로 실행됨
        Socket cs = new Socket("192.168.0.124", 9999);

        OutputStream os = cs.getOutputStream();
        PrintStream ps = new PrintStream(os);

        ps.println("GET / HTTP/1.1");
        ps.println("Host: 192.168.0.124");
        ps.println();
        // 서버한테 이걸 출력해주겠다.

        InputStream is = cs.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        // 성능 좋게
        BufferedReader br = new BufferedReader(isr);
    }
}
