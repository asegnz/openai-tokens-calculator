package com.asegnz;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int maxTokens = 50;
        BigDecimal costeInputToken = new BigDecimal("2.50");
        BigDecimal costeOutputToken = new BigDecimal("10");

        System.out.println("Bienvenid@ a la calculadora de tokens de modelos de OpenAI");

        while (!exit) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Introducir consulta a ChatGPT");
            System.out.println("2. Cambiar variable max_tokens (" + maxTokens + ") para la respuesta estimada de ChatGPT");
            System.out.println("3. Cambiar coste por millón de inputs tokens (" + costeInputToken + " $)");
            System.out.println("4. Cambiar coste por millón de output tokens (" + costeOutputToken + " $)");
            System.out.println("5. Salir");

            System.out.print("Ingrese el número de la opción deseada: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Ingrese su consulta a ChatGPT: ");
                    String consulta = scanner.nextLine();
                    Calculadora calculadora = new Calculadora(consulta, maxTokens, new Precio(costeInputToken, costeOutputToken));
                    BigDecimal coste = calculadora.calcula();
                    System.out.println("Su consulta tiene un coste asociado de "+coste+" $");
                }
                case 2 -> {
                    System.out.print("Ingrese el nuevo valor de la variable max_tokens: ");
                    maxTokens = scanner.nextInt();
                    System.out.println("El nuevo valor es: " + maxTokens);
                }
                case 3 -> {
                    System.out.print("Ingrese el nuevo valor coste por millón de inputs tokens ($): ");
                    costeInputToken = new BigDecimal(scanner.next());
                    System.out.println("El nuevo valor es: " + costeInputToken);
                }
                case 4 -> {
                    System.out.print("Ingrese el nuevo valor coste por millón de output tokens ($): ");
                    costeOutputToken = new BigDecimal(scanner.next());
                    System.out.println("El nuevo valor es: " + costeOutputToken);
                }
                case 5 -> {
                    System.out.println("Saliendo de la calculadora...");
                    exit = true;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
        System.out.println("¡Gracias por usar la calculadora!");
    }

}
