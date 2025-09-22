/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion_externa;

/**
 *
 * @author user
 */
public class HashTable {

    private String[] table;
    private int size;
    private int count; // cantidad de elementos para control de carga
    private final String DELETED = new String("<deleted>");

    public HashTable(int size) {
        this.size = size;
        table = new String[size];
        count = 0;
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, String value) {
        if (count == size) {
            System.out.println("Tabla llena, no se puede insertar");
            return;
        }

        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != null && table[index] != DELETED) {
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("No se encontró espacio para insertar");
                return;
            }
        }

        table[index] = value;
        count++;
    }

    public String search(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] != DELETED) {
                return table[index];
            }
            index = (index + 1) % size;
            if (index == startIndex) {
                break;
            }
        }
        return null; // no encontrado
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] != DELETED) {
                table[index] = DELETED;
                count--;
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) {
                break;
            }
        }
        System.out.println("Elemento no encontrado para eliminar");
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.insert(1, "Manzana");
        ht.insert(11, "Pera");    // Colisión, sondeo lineal
        ht.insert(21, "Banana");  // Colisión, sondeo lineal

        System.out.println("Tabla hash:");
        ht.display();

        System.out.println("Buscar clave 1: " + ht.search(11));
        
        ht.delete(11);
        System.out.println("Después de eliminar clave 1:");
        ht.display();
    }
}
