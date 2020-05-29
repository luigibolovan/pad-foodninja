package Client;

import java.net.*;
import java.io.*;
import java.util.ArrayList;


import Basic.Aliment;
import DB.*;
import Server.Server;


public class ClientHandler implements Runnable{

    private Socket client;
    private OutputStream outs;
    private DataInputStream in;
    private ObjectOutputStream outob;

    public ClientHandler(Socket clientsocket) throws IOException{
        this.client = clientsocket;
        this.outs = client.getOutputStream();
        this.in = new DataInputStream(client.getInputStream());
        this.outob = new ObjectOutputStream(outs);
    }

    @Override
    public void run() {
        try{
            while (true){
                String request = in.readUTF();
                String search_item;
                if(request.contains("search")) {
                    search_item = in.readUTF();
                    outob.writeObject(Server.search(search_item));
                    outob.flush();
                }

            }
        }catch (IOException e1){
            System.err.println("IOException in client handler");
            System.err.println(e1.getStackTrace());
        }finally {
            try {
                in.close();
                outob.close();
                outs.close();
                client.close();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }
    }
}
