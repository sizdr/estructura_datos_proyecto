package menus;

public class CancelarException extends Exception {
    public CancelarException() {
        super("La operación actual fue cancelada");
    }
}
