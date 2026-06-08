import AlmacenHuevos.MenuAlmacenHuevos;
import corral_pollos.MenuCorral;
import linea_vacunacion.MenuVacunacion;
import menus.CancelarException;
import menus.Menu;

public class MenuPrincipal extends Menu {
    private MenuCorral menuCorral;
    private MenuVacunacion menuVacunacion;
    private MenuReporte menuReporte;
    private MenuAlmacenHuevos menuAlmacenHuevos;

    MenuPrincipal(MenuCorral menuCorral, MenuVacunacion menuVacunacion,  MenuReporte menuReporte,  MenuAlmacenHuevos menuAlmacenHuevos) {
        this.menuCorral = menuCorral;
        this.menuVacunacion = menuVacunacion;
        this.menuReporte = menuReporte;
        this.menuAlmacenHuevos = menuAlmacenHuevos;
    }

    @Override
    protected String getOpciones() {
        return """
                GRANJA INTELIGENTE
                
                1. Gestionar corral de pollos
                2. Gestionar linea de vacunacion
                3. Gestionar almacén de huevos
                4. Ver reportes generales
                5. Salir
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean salirMenu = false;
        switch(opcion){
            case 1 -> menuCorral.seleccionarOpcion();
            case 2 -> menuVacunacion.seleccionarOpcion();
            case 3 -> menuAlmacenHuevos.seleccionarOpcion();
            case 4 -> menuReporte.seleccionarOpcion();
            case 5 -> salirMenu = true;
            default ->mostrarError("Opcion no valida.");
        }
        return salirMenu;
    }
}
