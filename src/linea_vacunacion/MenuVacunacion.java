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
    protected boolean procesarOpcion(int opcion) {
        return true;
    }
}
