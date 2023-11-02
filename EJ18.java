import java.util.Scanner;

public class MenuPrograma {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int dni = solicitarDNI(teclado);
        String nif = calcularNIF(dni);

        System.out.println("Su NIF es: " + nif);
    }

    public static int solicitarDNI(Scanner scanner) {
        System.out.print("Introduzca su DNI: ");
        return scanner.nextInt();
    }

    public static String calcularNIF(int dni) {
        String letrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = dni % 23;
        char letraNIF = letrasNIF.charAt(resto);

        return String.valueOf(dni) + letraNIF;
    }
}
