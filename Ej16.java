import java.util.Scanner;

public class Ej16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numeroReemplazo;

        do {
            System.out.print("Introduce el número que deseas reemplazar con una letra (0-9): ");
            numeroReemplazo = teclado.nextInt();
        } while (numeroReemplazo < 0 || numeroReemplazo > 9);

        char letra = 'C'; // La letra a sustituir

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        // Imprimir la secuencia con letras cuando se encuentra el número específico
                        System.out.printf("%d-%d-%d-", i, j, k);
                        imprimir(l, numeroReemplazo, letra);
                        System.out.println();
                        
                    }
                }
            }
        }
    }

    public static void imprimir(int numero, int numeroReemplazo, char letra) {
        if (numero == numeroReemplazo) {
            System.out.print(letra);
        } else {
            System.out.print(numero);
        }
    }
}