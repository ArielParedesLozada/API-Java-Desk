package Models;

public class Estudiante {
    public String cedula;
    public String nombre;
    public String apellido;
    public String direccion;
    public String telefono;

    @Override
    public String toString() {
        return this.cedula+" "+this.nombre+" "+this.apellido;
    }
}