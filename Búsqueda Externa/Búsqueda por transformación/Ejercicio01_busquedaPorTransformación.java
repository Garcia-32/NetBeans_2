import java.util.*;

class Prenda {
    String codigo;
    String nombre;
    double precio;

    public Prenda(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: S/ " + precio;
    }
}

public class TiendaRopa {
    private Map<Integer, List<Prenda>> hashTable = new HashMap<>();
    private int TAMANO = 10;

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % TAMANO;
    }

    public void agregarPrenda(Prenda prenda) {
        int idx = hash(prenda.codigo);
        hashTable.putIfAbsent(idx, new ArrayList<>());
        hashTable.get(idx).add(prenda);
    }

    public Prenda buscarPrenda(String codigo) {
        int idx = hash(codigo);
        if (hashTable.containsKey(idx)) {
            for (Prenda p : hashTable.get(idx)) {
                if (p.codigo.equals(codigo)) return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TiendaRopa tienda = new TiendaRopa();

        tienda.agregarPrenda(new Prenda("A100", "Polo Negro", 49.90));
        tienda.agregarPrenda(new Prenda("B200", "Jeans Azul", 99.50));
        tienda.agregarPrenda(new Prenda("C300", "Casaca", 150.00));
        tienda.agregarPrenda(new Prenda("D100", "Polo Negro Reposición", 55.00));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú Tienda de Ropa ---");
            System.out.println("1. Buscar prenda por código");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.print("Ingrese código de la prenda: ");
                String codigo = scanner.nextLine();

                Prenda encontrada = tienda.buscarPrenda(codigo);
                if (encontrada != null) {
                    System.out.println("Prenda encontrada: " + encontrada);
                } else {
                    System.out.println("No se encontró la prenda con código: " + codigo);
                }
            } else if (opcion == 2) {
                System.out.println("Gracias por usar la Tienda de Ropa. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
