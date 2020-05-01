package Client;

import Basic.*;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {
    public static void main(String[] args){
        try{
            ArrayList<Aliment> alimente = new ArrayList<Aliment>();

            Socket s = new Socket("localhost",4000);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            ObjectInputStream inobj = new ObjectInputStream(s.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.print("Introduceti actiunea: ");
                String str = br.readLine();

                if(str.equals("exit")) break;

                dout.writeUTF(str);
                dout.flush();

                str = br.readLine();
                if(str.equals("exit")) break;

                dout.writeUTF(str);
                dout.flush();

                alimente.add((Aliment) inobj.readObject());
            }

            Iterator i = alimente.iterator();

            while(i.hasNext()){
                System.out.println(i.next());
            }

            inobj.close();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
