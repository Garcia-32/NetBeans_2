
package hashtable;


public class HashTable {
    private Integer[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash simple
    private int hash(int key) {
        return key % size;
    }

    // Insertar un valor usando direccionamiento abierto con sondeo lineal
    public void insert(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 0;

        while (table[index] != null) {
            // Si la clave ya existe, no insertamos duplicados
            if (table[index] == key) {
                System.out.println("Clave " + key + " ya existe en la tabla.");
                return;
            }
            i++;
            index = (originalIndex + i) % size;
            if (index == originalIndex) {
                System.out.println("Tabla llena, no se puede insertar la clave " + key);
                return;
            }
        }
        table[index] = key;
        System.out.println("Clave " + key + " insertada en la posición " + index);
    }

    // Buscar un valor usando direccionamiento abierto con sondeo lineal
    public int search(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 0;

        while (table[index] != null) {
            if (table[index] == key) {
                return index; // Encontrado
            }
            i++;
            index = (originalIndex + i) % size;
            if (index == originalIndex) {
                break; // Hemos recorrido toda la tabla
            }
        }
        return -1; // No encontrado
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(7);

        ht.insert(10);
        ht.insert(20);
        ht.insert(5);
        ht.insert(15);
        ht.insert(7);

        int keyToSearch = 15;
        int result = ht.search(keyToSearch);
        if (result != -1) {
            System.out.println("Clave " + keyToSearch + " encontrada en la posición " + result);
        } else {
            System.out.println("Clave " + keyToSearch + " no encontrada en la tabla.");
        }
    }
}

