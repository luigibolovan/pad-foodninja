package Client;

import Basic.*;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {
    public static void main(String[] args){
        try{
            ArrayList<Aliment> alimente;

            Socket s = new Socket("localhost",4000);

            InputStream ins = s.getInputStream();
            ObjectInputStream inobj = new ObjectInputStream(ins);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";

            alimente = (ArrayList<Aliment>) inobj.readObject();
            Iterator iter = alimente.iterator();
            while (!str.equals("stop")) {
                str = br.readLine();
                if (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }
            inobj.close();
            ins.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
