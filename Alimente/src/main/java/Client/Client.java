package Client;

import Basic.*;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Client {
    private ArrayList<Aliment> alimente;
    private Socket s;
    private DataOutputStream dout;
    private ObjectInputStream inobj;
    private BufferedReader br;

    public Client() throws IOException{
        this.alimente = new ArrayList<Aliment>();
        this.s = new Socket("localhost",8080);
        this.dout = new DataOutputStream(s.getOutputStream());
        this.inobj = new ObjectInputStream(s.getInputStream());
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void thing() throws IOException, ClassNotFoundException {
        while(true) {
            System.out.print("Introduceti actiunea: ");
            String str = br.readLine();
            //1
            if(str.equals("exit")) break;

            dout.writeUTF(str);
            dout.flush();
            //sending the action

            str = br.readLine();
            if(str.equals("exit")) break;

            dout.writeUTF(str);
            dout.flush();

            alimente.add((Aliment) inobj.readObject());
        }
    }

    public void list_them(){
        Iterator i = alimente.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }
    }

    public void closing() throws IOException{
        inobj.close();
        dout.close();
        s.close();
    }

    public static void main(String[] args){
        Client c = null;

        try{
            c = new Client();
            c.thing();
            c.list_them();
        }catch(Exception e){
            System.out.println(e);
        } finally {
            try{
                c.closing();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
