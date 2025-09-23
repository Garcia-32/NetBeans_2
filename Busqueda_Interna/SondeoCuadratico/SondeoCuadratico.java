/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;


import java.util.Arrays;

public class SondeoCuadratico {

    // Función para realizar inserciones usando sondeo cuadrático
    static void insertarConSondeoCuadratico(int[] tabla, int tamano, int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int clave = datos[i];
            // Calculamos índice inicial con función hash simple: clave modulo tamaño tabla
            int indice = clave % tamano;

            // Si la posición en la tabla está vacía (-1), insertamos directamente
            if (tabla[indice] == -1) {
                tabla[indice] = clave;
            } else {
                // Si hay colisión, usamos el sondeo cuadrático:
                // Probamos índices con incremento cuadrático: (indice + j^2) % tamano
                boolean insertado = false;
                for (int j = 1; j < tamano; j++) {
                    int nuevoIndice = (indice + j * j) % tamano;
                    // Si encontramos posición vacía, insertamos ahí
                    if (tabla[nuevoIndice] == -1) {
                        tabla[nuevoIndice] = clave;
                        insertado = true;
                        break;
                    }
                }
                // Si no encontramos posición vacía, la tabla estaría llena para este dato
                if (!insertado) {
                    System.out.println("No se pudo insertar la clave: " + clave);
                }
            }
        }
    }

    public static void main(String[] args) {
        int tamanoTabla = 11; // Tamaño de la tabla hash
        int[] tablaHash = new int[tamanoTabla];
        Arrays.fill(tablaHash, -1); // Inicializamos tabla con -1 indicando posiciones vacías

        int[] datosAInsertar = {50, 700, 76, 85, 92, 73, 101}; // Datos a insertar

        // Insertamos los datos usando sondeo cuadrático
        insertarConSondeoCuadratico(tablaHash, tamanoTabla, datosAInsertar);

        // Mostramos el contenido de la tabla hash luego de la inserción
        System.out.println("Tabla hash después de inserciones con sondeo cuadrático:");
        for (int i = 0; i < tamanoTabla; i++) {
            System.out.println("Posición " + i + ": " + tablaHash[i]);
        }
    }
}
