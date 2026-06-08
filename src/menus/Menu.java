package menus;

import javax.swing.*;

public abstract class Menu {
    protected abstract String getOpciones();
    protected abstract boolean procesarOpcion(int opcion) throws CancelarException;

    public void seleccionarOpcion(){
        boolean cerrarMenu;
        int opcionSeleccionada;
        do {
            try {
                 opcionSeleccionada= pedirDatoNumerico(getOpciones() + "\nElige una opcion", "Menu de opciones");
            } catch (CancelarException e) {
                return;
            }
            try {
                cerrarMenu = procesarOpcion(opcionSeleccionada);
            } catch (CancelarException e){
                mostrarAviso(e.getMessage());
                cerrarMenu = false;
            }
        } while (!cerrarMenu);
    }

    protected String pedirDato(String mensaje, String titulo) throws CancelarException {
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = JOptionPane.showInputDialog(null, mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
            if (dato == null) {
                throw new CancelarException();
            }
            datoValidado = validarString(dato);
            if (!datoValidado.esValido()) {
                mostrarError(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return dato;
    }

    protected int pedirDatoNumerico(String mensaje, String titulo) throws CancelarException {
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = pedirDato(mensaje, titulo);
            datoValidado = validarEntero(dato);
            if (!datoValidado.esValido()) {
                mostrarError(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return Integer.parseInt(dato);
    }

    protected double pedirDatoDouble(String mensaje, String titulo) throws CancelarException {
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = pedirDato(mensaje, titulo);
            datoValidado = validarDouble(dato);
            if (!datoValidado.esValido()) {
                mostrarError(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return Double.parseDouble(dato);
    }

    protected void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }

    protected void mostrarDatos(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null,mensaje, titulo ,JOptionPane.PLAIN_MESSAGE);
    }

    protected void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje, "Error" ,JOptionPane.ERROR_MESSAGE);
    }

    protected void mostrarAviso(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje, "Aviso" ,JOptionPane.WARNING_MESSAGE);
    }

    private ErrorValidacion validarString(String dato){
        if (dato.trim().isEmpty()){
            return new ErrorValidacion("El campo no puede estar vacio", false);
        }
        return new ErrorValidacion(null, true);
    }

    private ErrorValidacion validarEntero(String dato){
        int datoParseado;
        try {
            datoParseado = Integer.parseInt(dato);
        } catch (NumberFormatException e) {
            return new ErrorValidacion("Solo se permiten numeros enteros en este campo", false);
        }
        if (datoParseado < 0){
            return new ErrorValidacion("Solo se permiten numeros positivos", false);
        }
        return new ErrorValidacion(null, true);
    }

    private ErrorValidacion validarDouble(String dato){
        double datoParseado;
        try {
            datoParseado = Double.parseDouble(dato);
        } catch (NumberFormatException e) {
            return new ErrorValidacion("El numeros decimal ingresado es invalido", false);
        }
        if (datoParseado < 0){
            return new ErrorValidacion("Solo se permiten numeros positivos", false);
        }
        return new ErrorValidacion(null, true);
    }
}
