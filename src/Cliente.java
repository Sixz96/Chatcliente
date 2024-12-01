// Cliente.java
import java.io.*;
import java.net.*;

public class Cliente {
    private String id;
    private String nombre;
    private String correo;

    public Cliente(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{id='" + id + "', nombre='" + nombre + "', correo='" + correo + "'}";
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        System.out.println("Ingrese sus datos de registro (ID, Nombre, Correo):");
        String registro = userInput.readLine();
        out.println("REGISTRO:" + registro);
        System.out.println(in.readLine());  // Respuesta del servidor

        String userInputLine;
        while ((userInputLine = userInput.readLine()) != null) {
            out.println(userInputLine);
            System.out.println("Respuesta del servidor: " + in.readLine());
        }
        
        socket.close();
    }
}