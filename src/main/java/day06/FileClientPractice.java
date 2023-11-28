package day06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileClientPractice {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            // 서버로 접속하는 코드, 서버가 실행되어 있어야 제대로 실행 됨
            Socket cs = new Socket("192.168.0.124", 8182);

            // 파일경로를 입력받을 스캐너
            Scanner sc = new Scanner(System.in);
            System.out.println("다운 받으실 파일경로를 입력하세요 : ");
            String filePath = sc.nextLine();

            // 클라이언트가 먼저 파일경로를 서버한테 보냄
            // 여기서부터 파일 경로를 보내는 코드\
            // 파일은 바이트로 보내야 함
            // FileInputStream 사용
            fos = new FileOutputStream(filePath);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
