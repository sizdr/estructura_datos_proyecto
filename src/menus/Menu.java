package menus;

import javax.swing.*;

public abstract class Menu {
    protected abstract String getOpciones();
    protected abstract void procesarOpcion(int opcion);

    public void seleccionarOpcion(){
        int opcionSeleccionada = pedirDatoNumerico(getOpciones() + "\nElige una opcion");
        procesarOpcion(opcionSeleccionada);
    }

    protected String pedirDato(String mensaje){
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = JOptionPane.showInputDialog(null, mensaje);
            datoValidado = validarString(dato);
            if (!datoValidado.esValido()) {
                mostrarMensaje(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return dato;
    }

    protected int pedirDatoNumerico(String mensaje){
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = pedirDato(mensaje);
            datoValidado = validarEntero(dato);
            if (!datoValidado.esValido()) {
                mostrarMensaje(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return Integer.parseInt(dato);
    }

    protected double pedirDatoDouble(String mensaje){
        String dato;
        ErrorValidacion datoValidado;
        do {
            dato = pedirDato(mensaje);
            datoValidado = validarDouble(dato);
            if (!datoValidado.esValido()) {
                mostrarMensaje(datoValidado.getMensajeError());
            }
        } while (!datoValidado.esValido());
        return Double.parseDouble(dato);
    }

    protected void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
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
