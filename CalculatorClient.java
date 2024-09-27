package Calculator;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            // Conectar al servidor en localhost y el puerto 8080
            Socket socket = new Socket("localhost", 8080);

            // Crear streams para enviar y recibir datos
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String operation;
            System.out.println("BIENVENIDOS A LA CALCULADORA DE JHONATAN");
            // Bucle para seguir enviando operaciones hasta que el usuario ingrese "salir"
            while (true) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("Ingrese la operación (+, -, *, /) o 'salir' para salir: ");
                operation = scanner.nextLine();

                // Si el usuario ingresa "salir", finalizamos el programa
                if (operation.equalsIgnoreCase("salir")) {
                    output.println("salir");
                    break;
                }

                // Verificar si la operación es válida
                if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                    System.out.println("Advertencia: Operación no válida. Intente nuevamente.");
                    continue; // Volver al inicio del bucle para pedir una nueva operación
                }

                // Leer los números del usuario después de validar la operación
                double num1, num2;
                try {
                    System.out.println("Ingrese el primer número: ");
                    num1 = scanner.nextDouble();
                    System.out.println("Ingrese el segundo número: ");
                    num2 = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("Advertencia: Entrada de número incorrecta. Intente nuevamente.");
                    scanner.nextLine(); // Limpiar el buffer
                    continue; // Volver al inicio del bucle
                }

                // Limpiar el buffer después de leer los números
                scanner.nextLine();

                // Enviar la operación y los números al servidor
                output.println(operation);
                output.println(num1);
                output.println(num2);

                // Leer la respuesta del servidor
                String result = input.readLine();
                System.out.println("Respuesta del servidor: " + result);
            }

            // Cerrar la conexión
            socket.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
