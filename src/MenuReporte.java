import menus.CancelarException;
import menus.Menu;

public class MenuReporte extends Menu {
    @Override
    protected String getOpciones() {
        return "";
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        return false;
    }
}
