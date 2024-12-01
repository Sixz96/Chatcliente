// Servidor.java
import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    private static Map<String, Cliente> clientes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor esperando conexiones...");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
            
            ClienteHandler clienteHandler = new ClienteHandler(clientSocket);
            new Thread(clienteHandler).start();
        }
    }

    static class ClienteHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClienteHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.startsWith("REGISTRO:")) {
                        registrarCliente(inputLine.substring(9));
                    } else {
                        System.out.println("Recibido: " + inputLine);
                        out.println("Servidor: " + inputLine);
                    }
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void registrarCliente(String datos) {
            String[] partes = datos.split(",");
            if (partes.length == 3) {
                String id = partes[0].trim();
                String nombre = partes[1].trim();
                String correo = partes[2].trim();
                
                Cliente nuevoCliente = new Cliente(id, nombre, correo);
                clientes.put(id, nuevoCliente);
                out.println("Registro exitoso para el cliente con ID: " + id);
                System.out.println("Nuevo cliente registrado: " + nuevoCliente);
            } else {
                out.println("Formato de registro incorrecto");
            }
        }
    }
}