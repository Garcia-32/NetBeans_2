
package tresenrayaspoo;
// Clase que representa a un jugador
public class Jugador {
 
    private String nombre;
    private char ficha;

    public Jugador(String nombre, char ficha) {
        System.out.println("Creando la clase Jugador para " + nombre + " con ficha " + ficha);
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public char getFicha() {
        return ficha;
    }
}

 
