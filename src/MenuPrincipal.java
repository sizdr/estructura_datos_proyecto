import corral_pollos.MenuCorral;
import linea_vacunacion.MenuVacunacion;
import menus.CancelarException;
import menus.Menu;

public class MenuPrincipal extends Menu {
    private MenuCorral menuCorral;
    private MenuVacunacion menuVacunacion;

    MenuPrincipal(MenuCorral menuCorral, MenuVacunacion menuVacunacion) {
        this.menuCorral = menuCorral;
        this.menuVacunacion = menuVacunacion;
    }

    @Override
    protected String getOpciones() {
        return """
                GRANJA INTELIGENTE
                1. Gestionar corral de pollos
                2. Gestionar linea de vacunacion
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        switch(opcion){
            case 1 -> menuCorral.seleccionarOpcion();
            case 2 -> menuVacunacion.seleccionarOpcion();
        }
        return false;
    }
}
