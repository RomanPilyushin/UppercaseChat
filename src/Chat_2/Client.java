package Chat_2;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String argv[]) throws Exception {
        String sentence = "";
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while(!sentence.equals("exit")) {
            Socket socket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println(modifiedSentence);
            socket.close();
        }
    }
}