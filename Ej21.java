import java.util.Scanner;
import java.util.Random;

public class Ej21 {
    public static void main(String[] args) throws InterruptedException {
        final int DELAY = 500;
        Random r = new Random();
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(lector.nextLine());

            if (opcion == 1) {
                jugarPartida(r, lector, DELAY);
            }

        } while (opcion != 0);

        System.out.println("Hasta pronto!!");
        lector.close();
    }

    public static void mostrarMenu() {
        System.out.println("***************************");
        System.out.println("*** JUEGO DE DADOS ONCE ***");
        System.out.println("***************************");
        System.out.println("1. Nueva partida ...");
        System.out.println("0. Salir");
        System.out.print("\nElige una opción: ");
    }

    public static int lanzarDado(Random r, int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    public static void jugarPartida(Random r, Scanner lector, int DELAY) throws InterruptedException {
        int porrasCPU = 0;
        int porrasPlayer = 0;

        do {
            int puntosPlayer = jugarTurnoJugador(r, lector, DELAY);
            int puntosCPU = jugarTurnoCPU(r, DELAY, puntosPlayer);
            porrasPlayer += evaluarResultado(puntosPlayer, puntosCPU, 11);
            porrasCPU += evaluarResultado(puntosCPU, puntosPlayer, 11);
            mostrarPuntuacion(porrasPlayer, porrasCPU);
        } while (porrasPlayer < 5 && porrasCPU < 5);

        mostrarResultadoFinal(porrasPlayer, porrasCPU);
    }

    public static int jugarTurnoJugador(Random r, Scanner lector, int DELAY) throws InterruptedException {
        int puntosPlayer = 0;
        boolean plantado = false;

        do {
            System.out.println("Jugador lanza el dado al aire ...");
            Thread.sleep(DELAY);
            int tiradaPlayer = lanzarDado(r, 1, 6);
            System.out.println("\n*****");
            System.out.println("* " + tiradaPlayer + " *");
            System.out.println("*****");
            puntosPlayer += tiradaPlayer;
            System.out.println("\nTu puntuación actual es " + puntosPlayer);
            plantado = plantarse(lector, puntosPlayer);
        } while (!plantado);

        return puntosPlayer;
    }

    public static boolean plantarse(Scanner lector, int puntos) {
        System.out.print("¿Deseas plantarte con " + puntos + " puntos? (s/n): ");
        char plantarse = lector.nextLine().charAt(0);
        return plantarse == 's' || plantarse == 'S';
    }

    public static int jugarTurnoCPU(Random r, int DELAY, int puntosPlayer) throws InterruptedException {
        int puntosCPU = 0;

        while (puntosCPU < puntosPlayer) {
            System.out.println("CPU lanza el dado al aire ...");
            Thread.sleep(DELAY);
            int tiradaCPU = lanzarDado(r, 1, 6);
            System.out.println("\n?????");
            System.out.println("? " + tiradaCPU + " ?");
            System.out.println("?????\n");
            puntosCPU += tiradaCPU;
            System.out.println("La puntuación actual de la CPU es " + puntosCPU);
        }

        return puntosCPU;
    }

    public static int evaluarResultado(int puntos1, int puntos2, int limite) {
        if (puntos1 == limite) {
            System.out.println("\n$$$$$$$$$$$$$$$$");
            System.out.println("$$$$ ¡ONCE! $$$$");
            System.out.println("$$$$$$$$$$$$$$$$");
            System.out.println("\n¡Bonificación! Doble porra");
            return 2;
        } else if (puntos1 > limite) {
            System.out.println("Ohh!! Te has pasado");
            System.out.println("Porra para la CPU");
            return 1;
        } else if (puntos2 > limite) {
            System.out.println("CPU se ha pasado. Porra para Player!!");
            return 1;
        } else if (puntos1 > puntos2) {
            System.out.println("CPU ha mejorado tu puntuación. Porra para CPU!!");
            return 1;
        } else if (puntos1 == puntos2) {
            System.out.println("Empate!! Porra para los dos");
            return 1;
        }
        return 0;
    }

    public static void mostrarPuntuacion(int porrasPlayer, int porrasCPU) {
        System.out.println("\n**********************");
        System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
        System.out.println("**********************");
        System.out.print("\nPulsa intro para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void mostrarResultadoFinal(int porrasPlayer, int porrasCPU) {
        if (porrasCPU >= 5) {
            System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a " + porrasPlayer + "\n");
        } else if (porrasPlayer >= 5) {
            System.out.println("\nPlayer gana la partida!!! por " + porrasPlayer + " porras a " + porrasCPU + "\n");
        }
    }
}