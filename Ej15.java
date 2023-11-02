import java.util.Scanner;

public class Ej15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    palabraMasLarga(teclado);
                    break;
                case 2:
                    palabraMasCorta(teclado);
                    break;
                case 3:
                    contarVocales(teclado);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Palabra más larga.");
        System.out.println("2. Palabra más corta.");
        System.out.println("3. Número de vocales.");
        System.out.println("------------------------------------");
        System.out.println("0. Salir");
        System.out.print("Introduce opción: ");
    }

    public static void palabraMasLarga(Scanner scanner) {
        System.out.println("Introduce tres palabras:");
        String palabra1 = scanner.nextLine();
        String palabra2 = scanner.nextLine();
        String palabra3 = scanner.nextLine();

        String palabraMasLarga = palabra1;
        if (palabra2.length() > palabraMasLarga.length()) {
            palabraMasLarga = palabra2;
        }
        if (palabra3.length() > palabraMasLarga.length()) {
            palabraMasLarga = palabra3;
        }

        System.out.println("La palabra más larga es: " + palabraMasLarga);
    }

    public static void palabraMasCorta(Scanner teclado) {
        System.out.println("Introduce tres palabras:");
        String palabra1 = teclado.nextLine();
        String palabra2 = teclado.nextLine();
        String palabra3 = teclado.nextLine();

        String palabraMasCorta = palabra1;
        if (palabra2.length() < palabraMasCorta.length()) {
            palabraMasCorta = palabra2;
        }
        if (palabra3.length() < palabraMasCorta.length()) {
            palabraMasCorta = palabra3;
        }

        System.out.println("La palabra más corta es: " + palabraMasCorta);
    }

    public static void contarVocales(Scanner scanner) {
        System.out.println("Introduce una palabra:");
        String palabra = scanner.nextLine();

        int contadorVocales = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if ("AEIOUaeiouáéíóúÁÉÍÓÚ".contains(String.valueOf(c))) {
                contadorVocales++;
            }
        }

        System.out.println("La palabra contiene " + contadorVocales + " vocales.");
    }
}