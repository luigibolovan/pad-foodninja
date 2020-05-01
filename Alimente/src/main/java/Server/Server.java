package Server;

import java.net.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import Basic.Aliment;
import Client.ClientHandler;
import DB.*;

public class Server {
    private static ArrayList<Aliment> alimente;
    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private static int port = 4000;
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(port);

            alimente = TestMainDB.test();

            try{
                while (true){
                    System.out.println("[SERVER] Waiting for client connection...");
                    Socket client = ss.accept();
                    System.out.println("[SERVER] Connected to a client");
                    ClientHandler clientThread = new ClientHandler(client);
                    clients.add(clientThread);

                    pool.execute(clientThread);

                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Aliment search(String nume_aliment){

        for(Aliment a : alimente)
            if((a.getName()).contains(nume_aliment))
                return a;
        return null;
    }
}
