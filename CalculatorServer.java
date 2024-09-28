//JHONATAN DAVID HERRERA ROJAS
//EJERCICIO SERVIDOR CLIENTE
package Calculator;
import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Crear el socket del servidor en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor de calculadora iniciado. Esperando conexiones...");

            // Esperar a que se conecte un cliente
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            // Crear streams para recibir y enviar datos
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String operation;

            // Bucle para seguir procesando operaciones hasta que el cliente envíe "salir"
            while (true) {
                // Leer la operación del cliente
                operation = input.readLine();
                
                // Si el cliente envía "salir", terminamos la conexión
                if (operation.equalsIgnoreCase("salir")) {
                    System.out.println("Cliente ha terminado la conexión.");
                    break;
                }

                // Leer los números enviados por el cliente
                double num1 = Double.parseDouble(input.readLine());
                double num2 = Double.parseDouble(input.readLine());

                // Procesar la operación
                double result = 0;
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            output.println("Error: División por cero.");
                            continue; // Vuelve a la próxima iteración
                        }
                        break;
                    default:
                        output.println("Error: Operación no soportada.");
                        continue; // Vuelve a la próxima iteración
                }

                // Enviar el resultado al cliente
                output.println("El resultado es: " + result);
            }

            // Cerrar la conexión
            socket.close();
           

            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
