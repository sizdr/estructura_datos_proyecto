package corral_pollos;

import menus.CancelarException;
import menus.Menu;
import modelos.Pollo;

import javax.swing.*;

public class MenuCorral extends Menu {
    private Lista listaCorral;

    public MenuCorral(Lista listaCorral) {
        this.listaCorral = listaCorral;
    }

    @Override
    protected String getOpciones() {
        return """
                GESTIÖN DE CORRAL
                1. Registrar pollo
                2. Mostrar pollos
                3. Buscar pollo por ID
                4. Buscar pollos enfermos
                5. Modificar datos de un pollo
                6. Eliminar pollo del corral
                7. Regresar al menu principal
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> registrarPollo();
            case 2 -> mostrarPollos();
            case 3 -> buscarPollo();
            case 4 -> mostrarEnfermos();
            case 5 -> editarPollo();
            case 6 -> eliminarPollo();
            case 7 -> cerrarMenu = true;
            default ->mostrarMensaje("Opcion no valida.");
        }
        return cerrarMenu;
    }

    private void registrarPollo() throws CancelarException {
        String nombre = pedirDato("Ingresa el nombre del pollo");
        String raza = pedirDato("Ingresa la raza del pollo");
        int edad = pedirDatoNumerico("Ingresa la edad en meses");
        double peso = pedirDatoDouble("Ingresa el peso en kg (ej: 2.5)");
        String salud;
        do {
             salud = pedirDato("Estado de salud (sano, enfermo, en observacion, vacunado)");
             if (!validarSalud(salud)) {
                 mostrarError("Salud invalido");
             }
        } while (!validarSalud(salud));
        salud = salud.trim().toLowerCase();
        listaCorral.agregar(new Pollo(nombre, raza, edad, peso, salud));
        mostrarMensaje("Pollo registrado exitosamente.");
    }

    private boolean validarSalud(String salud) {
        for (String estado : Pollo.getEstadosValidos()) {
            if (estado.equalsIgnoreCase(salud)) {
                return true;
            }
        }
        return false;
    }

    private void mostrarPollos(){
        if (listaCorral.vacia()) {
            mostrarMensaje("El corral esta vacio.");
            return;
        }
        mostrarMensaje(listaCorral.mostrarPollos());
    }

    private void buscarPollo() throws CancelarException {
        String id = pedirDato("Ingresa el ID del pollo a buscar");
        Pollo pollo = listaCorral.buscar(id);
        if (pollo == null) {
            mostrarAviso("No se encontro ningun pollo con ese ID.");
            return;
        }
        mostrarMensaje(pollo.toString());
    }

    private void mostrarEnfermos(){
        if (listaCorral.vacia()) {
            mostrarAviso("El corral esta vacio.");
            return;
        }
        mostrarMensaje(listaCorral.mostrarEnfermos());
    }

    private void eliminarPollo() throws CancelarException {
        String id = pedirDato("Ingresa el ID del pollo a eliminar");
        if (listaCorral.buscar(id) == null) {
            mostrarError("No se encontro ningun pollo con ese ID.");
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,
                "¿Estas seguro de eliminar este pollo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            listaCorral.eliminar(id);
            mostrarMensaje("Pollo eliminado exitosamente.");
        } else {
            mostrarAviso("Operacion cancelada.");
        }
    }

    private void editarPollo() throws CancelarException {
        String modId = pedirDato("Ingresa el ID del pollo a modificar");
        if (listaCorral.buscar(modId) == null) {
            mostrarAviso("No se encontro ningun pollo con ese ID.");
            return;
        }
        String nuevoNombre = pedirDato("Nuevo nombre");
        String nuevaRaza = pedirDato("Nueva raza");
        int nuevaEdad = pedirDatoNumerico("Nueva edad en meses");
        double nuevoPeso = pedirDatoDouble("Nuevo peso en kg");
        String nuevaSalud = pedirDato("Nuevo estado de salud");
        listaCorral.modificar(modId, nuevoNombre, nuevaRaza, nuevaEdad, nuevoPeso, nuevaSalud);
        mostrarMensaje("Pollo modificado exitosamente.");
    }

}