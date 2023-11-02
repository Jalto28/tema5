import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el ancho del rectángulo: ");
        int ancho = teclado.nextInt();

        System.out.print("Introduce el alto del rectángulo: ");
        int alto = teclado.nextInt();

        System.out.print("Introduce un carácter para dibujar el rectángulo: ");
        char caracter = teclado.next().charAt(0);

        rectangulo(ancho, alto, caracter);
    }

    public static void rectangulo(int ancho, int alto, char caracter) {
        for (int i = 1; i <= alto; i++) { //Repetirá el proceso de dibujo "alto" veces, una vez por cada fila del rectángulo.
            for (int j = 1; j <= ancho; j++) {//Repetirá el proceso de dibujo "ancho" veces, una vez por cada carácter en una fila del rectángulo
                System.out.print(caracter);
            }
            System.out.println(); // Salto de línea para pasar a la siguiente fila
        }
    }
}