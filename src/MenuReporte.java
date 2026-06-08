import corral_pollos.Lista;
import linea_vacunacion.Cola;
import menus.CancelarException;
import menus.Menu;

public class MenuReporte extends Menu {
    private Lista listaCorral;
    private Cola colaVacunacion;

    MenuReporte(Lista listaCorral, Cola cola) {
        this.listaCorral = listaCorral;
        this.colaVacunacion = cola;
    }

    @Override
    protected String getOpciones() {
        return """
                REPORTES GENERALES
                
                1. Total de pollos activoss
                2. Total de pollos enfermoss
                3. Total de pollos vacunadoss
                4. Total de pollos en fila de vacunación
                5. Total de huevos almacenadoss
                6. Peso total aproximado de huevos almacenados
                7. Regresar al menú principal\s
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> totalPollosActivos();
            case 2 -> totalPollosEnfermoss();
            case 3 -> totalPollosVacunados();
            case 4 -> totalPollosFilaVacunados();
            case 7 -> cerrarMenu = true;
            default ->mostrarError("Opcion no valida.");
        }
        return cerrarMenu;
    }

    private void totalPollosActivos(){
        mostrarDatos("Hay " + listaCorral.totalActivos() + " pollos activos", "Total activos");
    }

    private void totalPollosEnfermoss(){
        mostrarDatos("Hay " + listaCorral.totalEnfermos() + " pollos enfermos", "Total enfermos");
    }

    private void totalPollosVacunados(){
        mostrarDatos("Hay " + listaCorral.totalVacunados() + " pollos vacunados", "Totaal vacunados");
    }

    private void totalPollosFilaVacunados(){
        mostrarDatos("Hay " + colaVacunacion.getTamaño() + " pollos en fila de vacunacion", "Totaal en fila de vaunacion");
    }
}
