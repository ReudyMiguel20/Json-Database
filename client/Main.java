package client;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws IOException {
        socketClient();
    }

    // This method creates a socket client and connects to the server socket,
    // then sends a message to the server and receives a reply.
    public static void socketClient() throws IOException {
        String address = "127.0.0.1";
        int port = 23456;
        Socket socket = new Socket(InetAddress.getByName(address), port);

        System.out.println("Client started!");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String outputString = "Give me a record # 12";
        output.writeUTF(outputString);

        System.out.println("Sent: " + outputString);
        System.out.println("Received: " + input.readUTF());
    }
}
