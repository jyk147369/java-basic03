package day07.AdditionalFeatures;

import java.io.*;
import java.net.Socket;

public class MessageReceiveThread extends Thread {
    Socket socket;

    public MessageReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);

            while (true) {
                String message = bir.readLine();
                if (message.startsWith("img:")) {
                    BufferedInputStream bis = new BufferedInputStream(is);
                    FileOutputStream fos = new FileOutputStream("c:\\test02\\" + message.split(":")[1]);
                    int data = 0;
                    while( (data = bis.read()) != -1) {
                        fos.write(data);
                    }
                    fos.close();
                } else {
                    System.out.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
