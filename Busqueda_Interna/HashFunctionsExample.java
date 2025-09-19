
package hashtable;

public class HashFunctionsExample {
    private Integer[] table;
    private int size;

    public HashFunctionsExample(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash 1: módulo simple
    private int hashMod(int key) {
        return key % size;
    }

    // Función hash 2: suma de dígitos (para números)
    private int hashDigitSum(int key) {
        int sum = 0;
        int temp = key;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum % size;
    }

    // Función hash 3: multiplicación y parte fraccional (método de multiplicación)
    private int hashMultiplicacion(int key) {
        double A = 0.6180339887; // Constante de Knuth (parte fraccional del número áureo)
        double val = key * A;
        double frac = val - Math.floor(val);
        return (int) Math.floor(size * frac);
    }

    // Insertar usando una función hash seleccionada y sondeo lineal
    public void insert(int key, int hashFunction) {
        int index = 0;
        switch (hashFunction) {
            case 1:
                index = hashMod(key);
                break;
            case 2:
                index = hashDigitSum(key);
                break;
            case 3:
                index = hashMultiplicacion(key);
                break;
            default:
                System.out.println("Función hash no válida.");
                return;
        }

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
        System.out.println("Clave " + key + " insertada en la posición " + index + " usando función hash " + hashFunction);
    }

    // Buscar usando una función hash seleccionada y sondeo lineal
    public int search(int key, int hashFunction) {
        int index = 0;
        switch (hashFunction) {
            case 1:
                index = hashMod(key);
                break;
            case 2:
                index = hashDigitSum(key);
                break;
            case 3:
                index = hashMultiplicacion(key);
                break;
            default:
                System.out.println("Función hash no válida.");
                return -1;
        }

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

    // Mostrar contenido de la tabla
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posición " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashFunctionsExample ht = new HashFunctionsExample(11);

        // Insertar claves usando diferentes funciones hash
        ht.insert(123, 1);
        ht.insert(456, 2);
        ht.insert(789, 3);
        ht.insert(234, 1);
        ht.insert(567, 2);
        ht.insert(890, 3);

        ht.display();

        int keyToSearch = 789;
        int hashFunc = 3;
        int result = ht.search(keyToSearch, hashFunc);
        if (result != -1) {
            System.out.println("Clave " + keyToSearch + " encontrada en la posición " + result + " usando función hash " + hashFunc);
        } else {
            System.out.println("Clave " + keyToSearch + " no encontrada en la tabla.");
        }
    }
}

