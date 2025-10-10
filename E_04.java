import java.util.Arrays;

public class HashTableCuadratico {
    private static final String DELETED = "DELETED";
    private String[] tabla;
    private int tamaño;
    private int numElementos;

    public HashTableCuadratico(int capacidad) {
        this.tamaño = capacidad;
        this.tabla = new String[tamaño];
        this.numElementos = 0;
        Arrays.fill(tabla, null);
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    public boolean insertar(String clave) {
        if (numElementos >= tamaño / 2) {
            System.out.println("Tabla casi llena. Rehashing no implementado.");
            return false;
        }

        int indice = hash(clave);
        int i = 0;

        while (tabla[indice] != null && !tabla[indice].equals(DELETED)) {
            if (tabla[indice].equals(clave)) {
                return false; // Ya existe
            }
            i++;
            indice = (hash(clave) + i * i) % tamaño;
        }

        tabla[indice] = clave;
        numElementos++;
        return true;
    }

    public boolean buscar(String clave) {
        int indice = hash(clave);
        int i = 0;

        while (tabla[indice] != null) {
            if (tabla[indice].equals(clave)) {
                return true;
            }
            i++;
            indice = (hash(clave) + i * i) % tamaño;
            // Evitar bucle infinito si la tabla está llena
            if (i > tamaño) break;
        }
        return false;
    }

    public boolean eliminar(String clave) {
        int indice = hash(clave);
        int i = 0;

        while (tabla[indice] != null) {
            if (tabla[indice].equals(clave)) {
                tabla[indice] = DELETED;
                numElementos--;
                return true;
            }
            i++;
            indice = (hash(clave) + i * i) % tamaño;
            if (i > tamaño) break;
        }
        return false;
    }

    public void mostrarTabla() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < tamaño; i++) {
            if (tabla[i] == null) {
                System.out.println(i + ": null");
            } else if (tabla[i].equals(DELETED)) {
                System.out.println(i + ": DELETED");
            } else {
                System.out.println(i + ": " + tabla[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashTableCuadratico ht = new HashTableCuadratico(11); // Tamaño primo recomendado

        // Inserciones
        ht.insertar("manzana");
        ht.insertar("pera");
        ht.insertar("uva");
        ht.insertar("naranja");
        ht.insertar("kiwi");

        ht.mostrarTabla();

        // Búsquedas
        System.out.println("¿Existe 'pera'? " + ht.buscar("pera"));
        System.out.println("¿Existe 'mango'? " + ht.buscar("mango"));

        // Eliminación
        ht.eliminar("uva");
        System.out.println("\nDespués de eliminar 'uva':");
        ht.mostrarTabla();

        // Intentar insertar un duplicado
        System.out.println("Insertar 'pera' de nuevo: " + ht.insertar("pera"));

        // Insertar otro elemento
        ht.insertar("mango");
        System.out.println("\nDespués de insertar 'mango':");
        ht.mostrarTabla();
    }
}
