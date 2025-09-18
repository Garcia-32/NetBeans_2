
package hashtable;

public class HashTableQuadraticProbing {
    private Integer[] table;
    private int size;

    public HashTableQuadraticProbing(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash simple
    private int hash(int key) {
        return key % size;
    }

    // Insertar un valor usando sondeo cuadrático
    public void insert(int key) {
        int index = hash(key);
        int i = 0;

        while (table[(index + i * i) % size] != null) {
            if (table[(index + i * i) % size] == key) {
                System.out.println("Clave " + key + " ya existe en la tabla.");
                return;
            }
            i++;
            if (i == size) {
                System.out.println("Tabla llena, no se puede insertar la clave " + key);
                return;
            }
        }
        int insertIndex = (index + i * i) % size;
        table[insertIndex] = key;
        System.out.println("Clave " + key + " insertada en la posición " + insertIndex);
    }

    // Buscar un valor usando sondeo cuadrático
    public int search(int key) {
        int index = hash(key);
        int i = 0;

        while (table[(index + i * i) % size] != null) {
            if (table[(index + i * i) % size] == key) {
                return (index + i * i) % size;
            }
            i++;
            if (i == size) {
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
        HashTableQuadraticProbing ht = new HashTableQuadraticProbing(7);

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

