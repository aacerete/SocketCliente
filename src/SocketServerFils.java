import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 46990527d on 08/02/17.
 */
public class SocketServerFils    {

    public static void main(String[] args) {

        boolean escuchando = true;

        System.out.println("Creando servidor");

        /*El constructor del serversocket es diferente que el del cliente.
        Tiene métodos que el normal no tiene.
         */

        try {

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

            /*
            bind: significa vincular
             */
            /*
            El servidor escucha en la dirección que le digamos.
             */
            /**
             * El servidor tiene que ser la misma màquina que ejecuta el programa servidor?
             */

            serverSocket.bind(addr);
            System.out.println("Escuchando");

            /**
             * Aquí és donde el servidor se quedará escuchando!
             */

            while(escuchando){

                Socket socketdeescucha = serverSocket.accept();

                FilServidor th = new FilServidor(socketdeescucha);
                th.start();
            }
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}