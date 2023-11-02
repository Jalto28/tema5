import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca su NIF (sin espacios ni guiones): ");
        String nifUsuario = teclado.next();

        if (verificarNIF(nifUsuario)) {
            System.out.println("El NIF es válido.");
        } else {
            System.out.println("El NIF no es válido.");
        }
    }

    public static boolean verificarNIF(String nif) { //Este método recibe el NIF como una cadena de texto.
        if (nif.length() == 9) { //Verificamos que la longitud del NIF sea de 9 caracteres.
            char letraUsuario = nif.charAt(8); 
            String numerosNIF = nif.substring(0, 8);
            String letrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";

            try {
                int dni = Integer.parseInt(numerosNIF);
                int resto = dni % 23;
                char letraNIF = letrasNIF.charAt(resto);

                return letraNIF == letraUsuario;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }
}