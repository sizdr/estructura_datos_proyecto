package linea_vacunacion;

import menus.Menu;

public class MenuVacunacion extends Menu {
    private Cola colaVacunacion;

    public MenuVacunacion(Cola colaVacunacion){
        this.colaVacunacion = colaVacunacion;
    }

    @Override
    protected String getOpciones() {
        return """
                1. Agregar pollo
                2. Desencolar pollo
                """;
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                String id = pedirDato("Ingresa el id del pollo");
                String nombre = pedirDato("Ingresa el nombre del pollo");
                String raza = pedirDato("Ingresa la raza del pollo");
                int edad = pedirDatoNumerico("Ingresa la edad en meses del pollo");
                double peso;
                String estado_salud;

        }
    }
}
