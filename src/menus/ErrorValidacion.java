package menus;

public class ErrorValidacion {
    private String mensajeError;
    private boolean valido;

    ErrorValidacion(String mensajeError) {
        this.mensajeError = mensajeError;
        this.valido = false;
    }

    ErrorValidacion(String mensajeError, boolean valido) {
        this.mensajeError = mensajeError;
        this.valido = valido;
    }

    public boolean esValido() {
        return valido;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
