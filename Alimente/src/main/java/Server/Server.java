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
            /*Iterator iter = alimente.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }*/

            OutputStream outs = s.getOutputStream();
            ObjectOutputStream outob = new ObjectOutputStream(outs);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            while(!str.equals("stop")) {
                Iterator iter = alimente.iterator();
                while (iter.hasNext()) {
                    outob.writeObject(alimente);
                }
                outob.flush();
                str = br.readLine();
            }

            outob.close();
            outs.close();
            s.close();
            ss.close();

        }catch (Exception e){System.out.println(e);}
    }
}
