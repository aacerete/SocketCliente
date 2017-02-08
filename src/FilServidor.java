import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 46990527d on 08/02/17.
 */
public class FilServidor extends Thread{

    Socket socketescuchado;

    public FilServidor(Socket s){

        socketescuchado = s;

    }

    @Override
    public void run() {

        System.out.println("Se ha recibido una llamada!");

        try {
            InputStream is = socketescuchado.getInputStream();
            OutputStream os = socketescuchado.getOutputStream();
            byte[] mensaje = new byte[6000];
            is.read(mensaje);
            System.out.println("mensaje recibido: " + new String(mensaje));
            System.out.println(socketescuchado.getInetAddress().toString());
            System.out.println("Cerrando!");
            os.write("Adeu!".getBytes());
            socketescuchado.close();
            is.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}