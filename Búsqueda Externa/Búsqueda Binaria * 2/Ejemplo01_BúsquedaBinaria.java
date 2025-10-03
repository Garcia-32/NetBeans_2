import java.util.*;
public class BusquedaExterna {


// Función que realiza búsqueda binaria en el array ordenado.
// Devuelve la posición del elemento si se encuentra, o -1 si no.
 public static int busquedaBinaria(int array[], int n, int elemento) {
    int desde = 0, hasta = n - 1, medio;

    while (desde <= hasta) {
        medio = (desde + hasta) / 2;
if (array[medio] == elemento) {
            return medio; // Elemento encontrado
        }
       else if (array[medio] > elemento) {
            hasta = medio - 1; // Buscar en la mitad izquierda
        }
        else {
            desde = medio + 1; // Buscar en la mitad derecha
        }
    }
    return -1; // No encontrado
}

public static void  main(String[] args){
    Scanner consola = new Scanner(System.in); 
    int N =18; 
    int[] array = new int[N];
    //los valores ordenados multiplos de 2
    for (int i = 0; i < N; i++) {
        array[i] = i * 2; // Array con valores pares: 0, 2, 4, ...
    }
    // Inicializar array con valores ordenados (ejemplo)
    for (int i = 0; i < N; i++) {
        array[i] = i * 2; // Array con valores pares: 0, 2, 4, ...
    }

    
    System.out.printf("Ingrese el numero a buscar: ");
    int elemento = consola.nextInt();

    int posicion = busquedaBinaria(array, N, elemento);

    if (posicion != -1) {
        System.out.printf("Elemento %d encontrado en la posicion %d.\n", elemento, posicion);
    }
    else {
        System.out.printf("Elemento %d no encontrado en el array.\n", elemento);
    }
    consola.close();
    
}
