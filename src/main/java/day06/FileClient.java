package day06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    public static void main(String[] args) {
        try {
            // 서버로 접속하는 코드, 서버가 실행되어 있어야 제대로 실행 됨
            System.out.println("서버에 연결중입니다.");
            Socket cs = new Socket("192.168.0.124", 8182);
            System.out.println("서버에 연결되었습니다.");

            // 클라이언트가 먼저 파일명을 입력해서 서버로 보낸다.
            // 여기서부터 글자를 보내는 코드
            OutputStream os = cs.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);

            Scanner sc = new Scanner(System.in);
            System.out.print("서버에게 요청할 파일명을 입력해주세요 : ");
            String fileName = sc.nextLine();

            bow.write(fileName + "\n");
            bow.flush();
            // 여기까지 보내는 코드

            // 클라이언트가 요청할 파일을 서버가 보내준다
            // 클라이언트는 서버가 준 파일을 저장한다.
            // 여기서부터 받는 코드
            System.out.println("요청한 " + fileName + " 파일을 받습니다.");
            InputStream is = cs.getInputStream();

            // 이건 글자를 받는 코드
            /*InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);*/

            // byte단위로 파일을 읽어 올때 사용하는 버퍼 스트림
            BufferedInputStream bis = new BufferedInputStream(is);

            // 주어진 File 객체가 가리키는 파일을 쓰기 위한 객체를 생성
            System.out.println(fileName + " 파일을 저장합니다.");
            // 받아온 파일을 경로에 저장한다.
            FileOutputStream fos = new FileOutputStream("c:\\test2\\" + fileName);
            // 저장할 경로를 만들어둬야 함 안그럼 에러
            int data = 0;
            // 더이상 읽을 값이 없으면 -1을 리턴.
            while( (data = bis.read()) != -1) {
                fos.write(data);
            }
            // 여기까지 받는 코드

            // 메소드 다 닫기
            fos.close();
            bis.close();
            bow.close();
            cs.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 예외처리

    }
}

