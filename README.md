# Cliente-servidor-calculadora
# Calculadora Cliente-Servidor en Java

Este proyecto implementa una calculadora básica con arquitectura cliente-servidor utilizando sockets en Java, y se desarrolla por medio de netbeans.

## Funcionamiento

- **Cliente**: El cliente solicita al usuario ingresar una operación matemática básica (+, -, *, /) y dos números. Luego, envía estos datos al servidor.
- **Servidor**: El servidor recibe la operación y los números, realiza el cálculo, y devuelve el resultado al cliente. Si la operación es inválida o se intenta dividir por cero, el servidor responde con un mensaje de error.

### Características:

- Soporta las operaciones básicas: suma, resta, multiplicación y división.
- El cliente y el servidor se comunican a través de sockets.
- Manejo de errores tanto en el cliente como en el servidor:
  - Advertencia por caracteres de operación incorrectos.
  - Error por intento de división por cero.

## Cómo usar

1. **Ejecutar primero el servidor**:
   - Abre una terminal y navega hasta la carpeta donde se encuentra el archivo `CalculatorServer.java`.
   - Compila el servidor:
     ```bash
     javac CalculatorServer.java
     ```
   - Ejecuta el servidor:
     ```bash
     java CalculatorServer
     ```

2. **Ejecutar el cliente**:
   - Abre otra terminal y navega hasta la carpeta donde se encuentra el archivo `CalculatorClient.java`.
   - Compila el cliente:
     ```bash
     javac CalculatorClient.java
     ```
   - Ejecuta el cliente:
     ```bash
     java CalculatorClient
     ```

