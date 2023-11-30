package day07.AdditionalFeatures;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MessageSendThread extends Thread {
    Socket socket;

    public MessageSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("서버에게 보낼 내용을 입력해주세요 : ");
                String message = sc.nextLine();
                if (message.startsWith("img:")) {
                    bow.write(message + "\n");
                    bow.flush();
                    FileInputStream fis = new FileInputStream("c:\\test02\\"+message.split(":")[1]);
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    int data = 0;
                    while( (data = fis.read()) != -1) {
                        bos.write(data);
                    }
                    bos.flush();
                    fis.close();
                } else {
                    bow.write(message + "\n");
                    bow.flush();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
