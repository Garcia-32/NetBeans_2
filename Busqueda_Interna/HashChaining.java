
package hashtable;

import java.util.LinkedList;

public class HashChaining {
    private LinkedList<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashChaining(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Función hash simple
    private int hash(int key) {
        return key % size;
    }

    // Insertar un valor en la tabla hash con encadenamiento
    public void insert(int key) {
        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
            System.out.println("Clave " + key + " insertada en la lista en la posición " + index);
        } else {
            System.out.println("Clave " + key + " ya existe en la tabla.");
        }
    }

    // Buscar un valor en la tabla hash con encadenamiento
    public boolean search(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    // Eliminar un valor de la tabla hash con encadenamiento
    public void delete(int key) {
        int index = hash(key);
        if (table[index].remove((Integer) key)) {
            System.out.println("Clave " + key + " eliminada de la posición " + index);
        } else {
            System.out.println("Clave " + key + " no encontrada en la tabla.");
        }
    }

    // Mostrar el contenido de la tabla hash
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Posición " + i + ": ");
            for (Integer key : table[i]) {
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        HashChaining ht = new HashChaining(7);

        ht.insert(10);
        ht.insert(20);
        ht.insert(5);
        ht.insert(15);
        ht.insert(7);
        ht.insert(20); // Intento de insertar duplicado

        ht.display();

        int keyToSearch = 15;
        if (ht.search(keyToSearch)) {
            System.out.println("Clave " + keyToSearch + " encontrada en la tabla.");
        } else {
            System.out.println("Clave " + keyToSearch + " no encontrada en la tabla.");
        }

        ht.delete(20);
        ht.delete(100); // Intento de eliminar clave no existente

        ht.display();
    }
}
