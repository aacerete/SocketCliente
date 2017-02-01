import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 46990527d on 01/02/17.
 */
public class SocketServidor {

    public static void main(String[] args) {

        //172.73.1.15

        try{

            System.out.println("Creando servidor");
            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind ");
            //escuchar otras direcciones : substituir localhost por "0.0.0.0"
            InetSocketAddress inetSocketAddress = new InetSocketAddress("0.0.0.0", 5555);
            serverSocket.bind(inetSocketAddress);

            System.out.println("aceptando conexiones");
            Socket socket = serverSocket.accept();

            System.out.println("Conexión recibida");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] mensaje = new byte[25];
            is.read(mensaje);

            System.out.println("Mensaje recibido " + new String(mensaje));

            System.out.println("Cerrando el socket");
            socket.close();

            System.out.println("Cerrando el socket servidor");
            serverSocket.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
