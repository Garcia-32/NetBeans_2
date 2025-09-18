
package hashtable;

public class HashTableLinearProbing {
    private Integer[] table;
    private int size;

    public HashTableLinearProbing(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash simple
    private int hash(int key) {
        return key % size;
    }

    // Insertar un valor usando sondeo lineal
    public void insert(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 0;

        while (table[index] != null) {
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

    // Buscar un valor usando sondeo lineal
    public int search(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 0;

        while (table[index] != null) {
            if (table[index] == key) {
                return index;
            }
            i++;
            index = (originalIndex + i) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return -1;
    }

    // Mostrar el contenido de la tabla
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posición " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashTableLinearProbing ht = new HashTableLinearProbing(7);

        ht.insert(10);
        ht.insert(20);
        ht.insert(5);
        ht.insert(15);
        ht.insert(7);

        ht.display();

        int keyToSearch = 15;
        int result = ht.search(keyToSearch);
        if (result != -1) {
            System.out.println("Clave " + keyToSearch + " encontrada en la posición " + result);
        } else {
            System.out.println("Clave " + keyToSearch + " no encontrada en la tabla.");
        }
    }
}
