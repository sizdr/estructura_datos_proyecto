package menus;

import javax.swing.*;

public abstract class Menu {
    protected abstract String getOpciones();
    protected abstract void procesarOpcion(int opcion);

    public void seleccionarOpcion(){
        int opcionSeleccionada = pedirDatoNumerico(getOpciones() + "\nElige una opcion");
        procesarOpcion(opcionSeleccionada);
    }

    public String pedirDato(String mensaje){
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

    public int pedirDatoNumerico(String mensaje){
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

    public void mostrarMensaje(String mensaje){
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
}
