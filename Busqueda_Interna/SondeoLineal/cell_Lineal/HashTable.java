/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;


public class HashTable {
    private HashCell[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new HashCell[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key, String value) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null && !table[index].isDeleted) {
            if (table[index].key == key) { // actualizar valor si clave existe
                table[index].value = value;
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("Tabla llena, no se puede insertar.");
                return;
            }
        }
        table[index] = new HashCell(key, value);
    }

    public String search(int key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key == key) {
                return table[index].value;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key == key) {
                table[index].isDeleted = true;
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }
        System.out.println("Elemento no encontrado para eliminar.");
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] == null) {
                System.out.println(i + ": Vacío");
            } else if (table[i].isDeleted) {
                System.out.println(i + ": Borrado");
            } else {
                System.out.println(i + ": (" + table[i].key + ", " + table[i].value + ")");
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        hashTable.insert(10, "Perro");
        hashTable.insert(3, "Gato");
        hashTable.insert(17, "Elefante");
        hashTable.insert(24, "Tigre");

        System.out.println("Tabla hash luego de inserciones:");
        hashTable.display();

        System.out.println("Buscar clave 17: " + hashTable.search(17));

        hashTable.delete(17);
        System.out.println("Tabla hash luego de eliminar clave 17:");
        hashTable.display();
    }
}

