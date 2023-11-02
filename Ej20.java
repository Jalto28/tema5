import java.util.Scanner;

public class Ej20 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce tu fecha de nacimiento (dd-mm-aaaa): ");
        String fechaNacimiento = teclado.next();

        int luckyNumber = calcularLuckyNumber(fechaNacimiento);
        System.out.println("Tu número de la suerte es: " + luckyNumber);
    }

    public static int calcularLuckyNumber(String fechaNacimiento) {
        int sumaDigitos = 0;

        for (char c : fechaNacimiento.toCharArray()) {
            if (Character.isDigit(c)) {
                sumaDigitos += Character.getNumericValue(c);
            }
        }

        while (sumaDigitos > 9) {
            int nuevaSuma = 0;
            while (sumaDigitos > 0) {
                nuevaSuma += sumaDigitos % 10;
                sumaDigitos /= 10;
            }
            sumaDigitos = nuevaSuma;
        }

        return sumaDigitos;
    }
}