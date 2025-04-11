package Views;

import java.util.ArrayList;

import Controllers.APIEstudiantes;
import Controllers.ResponseEstudiantes;
import Models.Estudiante;

public class Test {
    public static void main(String[] args) {
        String path = "http://192.168.1.11/servidor/MVC/Controllers/APIRest.php";
        APIEstudiantes api = APIEstudiantes.getInstance(path);
        Estudiante waza = new Estudiante();
        waza.apellido = "Atreides";
        waza.cedula = "9999999";
        waza.direccion = "Ambato";
        waza.nombre = "Ghaima";
        waza.telefono = "098989";
        try {
            // api.PUT("1898700",waza);
            api.GET();
        } catch (Exception e) {
            System.out.println("Error en el get "+e.getMessage());
        }
        String response = api.fetchData();
        ArrayList<Estudiante> estudiantes = (new ResponseEstudiantes()).parseEstudiantes(response);
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

    }
}
