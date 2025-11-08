/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public  abstract empleado{
private String nombre;
private String id;

public empleado(String nombre, String id){
    this.nombre=nombre;
    this.id=id;
    
}
//gettera and setters

public String getNombre(){
    return nombre;
}
public String getId(){
    
}

//metodo concreto
public void mostrarDetalles(){
    System.out.println("--- Detalles del Empleado ---");
    System.out.println("nombre: "+ nombre);
    System.out.println("Id: "+ id);
    
}

//metodos abstractos
//debe implementarse en subclasess concretas
public abstract double calcularSalario();

}