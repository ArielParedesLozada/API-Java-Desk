package Views;

import Controllers.Facades.FacadeEstudiante;
import Models.Estudiante;

public class Test {
    public static void main(String[] args) {
        String path = "http://192.168.1.11/servidor/MVC/Controllers/APIRest.php";
        FacadeEstudiante facade = new FacadeEstudiante(path);
        Estudiante nuevo = new Estudiante();
        nuevo.apellido = "Ji";
        nuevo.cedula = "185565";
        nuevo.direccion = "China";
        nuevo.nombre = "Luo";
        nuevo.telefono = "098989";
        facade.postEstudiante(nuevo);
        // facade.putEstudiante(nuevo);
        // facade.deleteEstudiante(nuevo);
        for (Estudiante estudiante : facade.getEstudiantes()) {
            System.out.println(estudiante);
        }
    }
}
