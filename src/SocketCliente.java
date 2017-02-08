import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by 46990527d on 01/02/17.
 */
public class SocketCliente {

    public static void main(String[] args) {

        try{

            System.out.println("Creando socket cliente");

            //Socket de tcp
            Socket cliente = new Socket();

            //socket de udp
            //DatagramSocket udp = new DatagramSocket();

            System.out.println("Estableciendo conexion");

            //localhost = 127.0.0.1
            SocketAddress adress = new InetSocketAddress("localhost", 5555);

            cliente.connect(adress);

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            System.out.println("Enviando mensaje");
            String mensaje = "mi primer mensaje que navega";
            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente...");
            is.read();

            cliente.close();

            System.out.println("Terminado");


        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
