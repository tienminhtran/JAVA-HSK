package mang;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
// nhận xong gở
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.21.71.232", 8080);
            System.out.println("Connected to server!");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("TTTT");
           
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//21010611_TranMinhTien_W2_theoThay_ghi_doc_fil