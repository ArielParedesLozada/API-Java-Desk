package Views;

import Controllers.Facades.FacadeEstudiante;
import Controllers.Facades.FacadeEstudianteAPI1;
import Models.Estudiante;

public class Test {
    public static void main(String[] args) {
        String path = "http://localhost/servidor/MVC/Controllers/APIRest.php";
        FacadeEstudianteAPI1 facade = new FacadeEstudianteAPI1(path);
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
