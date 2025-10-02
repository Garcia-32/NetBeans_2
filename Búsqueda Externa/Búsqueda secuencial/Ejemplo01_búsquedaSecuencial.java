public class BusquedaExterna {

    // Método para buscar un valor en un arreglo usando búsqueda secuencial
    public static int busquedaSecuencial(int[] datos, int valorBuscado) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == valorBuscado) {
                return i;  // retorna el índice donde se encontró el valor
            }
        }
        return -1;  // retorna -1 si no se encontró el valor
    }

    public static void main(String[] args) {
        int[] datos = {23, 45, 12, 67, 34, 89, 0, 56};
        int valor = 34;

        int resultado = busquedaSecuencial(datos, valor);

        if (resultado == -1) {
            System.out.println("El valor " + valor + " no se encontró en el arreglo.");
        } else {
            System.out.println("El valor " + valor + " se encontró en el índice: " + resultado);
        }
    }
}
