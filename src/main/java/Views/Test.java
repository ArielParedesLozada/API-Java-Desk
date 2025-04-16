package Views;

import Controllers.Facades.FacadeEstudiante;
import Models.Estudiante;

public class Test {
    public static void main(String[] args) {
        String path = "http://localhost/servidor/MVC/Controllers/Routes/APIEstudiantes.php";
        FacadeEstudiante facade = new FacadeEstudiante(path);
        Estudiante nuevo = new Estudiante();
        nuevo.apellido = "Atreides";
        nuevo.cedula = "18556565";
        nuevo.direccion = "Arrakis";
        nuevo.nombre = "Ghanima";
        nuevo.telefono = "0989829";
        // facade.postEstudiante(nuevo);
        // facade.putEstudiante(nuevo);
        // facade.deleteEstudiante(nuevo);
        System.out.println(facade.getEstudiantes().getClass());
        for (Estudiante estudiante : facade.getEstudiantes()) {
            System.out.println(estudiante);
        }
    }
}
