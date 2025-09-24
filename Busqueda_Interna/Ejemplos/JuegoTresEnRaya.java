package tresenrayaspoo;

// Clase principal que controla el juego
public class JuegoTresEnRaya {

   

    public static void main(String[] args) {
        System.out.println("Creando la clase principal TresEnRaya y comenzando el juego...");

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Crear jugadores (relación estática: TresEnRaya "tiene" Jugadores)
        Jugador jugador1 = new Jugador("Jugador 1", 'X');
        Jugador jugador2 = new Jugador("Jugador 2", 'O');

        // Crear tablero (relación estática: TresEnRaya "tiene" Tablero)
        Tablero tablero = new Tablero();

        Jugador jugadorActual = jugador1;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.println(jugadorActual.getNombre() + " (" + jugadorActual.getFicha() + "), ingresa fila (0-2):");
            int fila = scanner.nextInt();
            System.out.println(jugadorActual.getNombre() + " (" + jugadorActual.getFicha() + "), ingresa columna (0-2):");
            int columna = scanner.nextInt();

            // Intentar colocar ficha (relación dinámica: Jugador interactúa con Tablero)
            if (tablero.colocarFicha(fila, columna, jugadorActual.getFicha())) {
                System.out.println(jugadorActual.getNombre() + " colocó su ficha en (" + fila + ", " + columna + ")");
                if (tablero.hayGanador(jugadorActual.getFicha())) {
                    tablero.mostrarTablero();
                    System.out.println("¡" + jugadorActual.getNombre() + " ganó!");
                    // Mostrar mensaje al perdedor
                    Jugador perdedor = (jugadorActual == jugador1) ? jugador2 : jugador1;
                    System.out.println("Lo siento " + perdedor.getNombre() + ", perdiste.");
                    juegoTerminado = true;
                } else if (tablero.tableroLleno()) {
                    tablero.mostrarTablero();
                    System.out.println("El juego terminó en empate.");
                    juegoTerminado = true;
                } else {
                    // Cambiar jugador
                    jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
                }
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }

        scanner.close();
        System.out.println("Fin del juego.");
    }
}  

