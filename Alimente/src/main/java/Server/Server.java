package Server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import Basic.Aliment;
import DB.*;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket s = ss.accept();

            ArrayList<Aliment> alimente = TestMainDB.test();

            OutputStream outs = s.getOutputStream();
            ObjectOutputStream outob = new ObjectOutputStream(outs);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            outob.writeObject(alimente);
            String str = "";
            while (!str.equals("stop")) {
                str = br.readLine();
            }
            outob.close();
            outs.close();
            s.close();
            ss.close();

        }catch (Exception e){System.out.println(e);}
    }
}
