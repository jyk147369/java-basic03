package day07.AdditionalFeatures;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadClient {
    public static void main(String[] args) {
        /*String serverIp = "192.168.0.100";
        int serverPort = 9999;

        try {
            Socket socket = new Socket(serverIp, serverPort);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bow = new BufferedWriter(osw);
            Scanner sc = new Scanner(System.in);
            System.out.print("사용할 ID를 입력해주세요 : ");
            String id = sc.nextLine();

            bow.write(id + "\n");
            bow.flush();

            Thread messageSendThread = new MessageSendThread(socket);
            messageSendThread.start();

            Thread messageReceiveThread = new MessageReceiveThread(socket);
            messageReceiveThread.start();

            while (true) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }
}
