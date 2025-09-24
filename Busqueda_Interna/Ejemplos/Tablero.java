
package tresenrayaspoo;


public class Tablero {
 // Clase que representa el tablero del juego

    private char[][] tablero;
    private final int tamaño = 3;

    public Tablero() {
        System.out.println("Creando la clase Tablero...");
        tablero = new char[tamaño][tamaño];
        // Inicializar el tablero con espacios vacíos
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("Estado actual del tablero:");
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(" " + tablero[i][j]);
                if (j < tamaño - 1) System.out.print(" |");
            }
            System.out.println();
            if (i < tamaño - 1) System.out.println("---+---+---");
        }
    }

    public boolean colocarFicha(int fila, int columna, char ficha) {
        if (fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño) {
            if (tablero[fila][columna] == ' ') {
                tablero[fila][columna] = ficha;
                return true;
            }
        }
        return false;
    }

    public boolean hayGanador(char ficha) {
        // Revisar filas
        for (int i = 0; i < tamaño; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
        }
        // Revisar columnas
        for (int j = 0; j < tamaño; j++) {
            if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
                return true;
            }
        }
        // Revisar diagonales
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            return true;
        }
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
            return true;
        }
        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}


   

