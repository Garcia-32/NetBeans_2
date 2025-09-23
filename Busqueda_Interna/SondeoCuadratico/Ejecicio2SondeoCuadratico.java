/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;

/**
 *
 * @author user
 */
public class Ejecicio2SondeoCuadratico {
    
    private int[] tabla;
    private int tamano;
    private int valorVacio = -1; // Valor para indicar posición vacía

    public Ejercicio2SondeoCuadratico(int tamano) {
        this.tamano = tamano;
        tabla = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = valorVacio; // Inicializar tabla vacía
        }
    }

    // Función hash simple
    private int hash(int clave) {
        return clave % tamano;
    }

    // Inserción usando sondeo cuadrático
    public void insertar(int clave) {
        int indice = hash(clave);

        if (tabla[indice] == valorVacio) {
            tabla[indice] = clave; // Insertar directamente si posición está vacía
        } else {
            // Colisión detectada, aplicar sondeo cuadrático
            int i = 1;
            while (i < tamano) {
                int nuevoIndice = (indice + i * i) % tamano;
                if (tabla[nuevoIndice]
