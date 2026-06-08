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
            default ->mostrarError("Opcion no valida.");
        }
        return cerrarMenu;
    }

    private void registrarPollo() throws CancelarException {
        String titulo = "Registrar Pollo";
        String nombre = pedirDato("Ingresa el nombre del pollo", titulo);
        String raza = pedirDato("Ingresa la raza del pollo", titulo);
        int edad = pedirDatoNumerico("Ingresa la edad en meses", titulo);
        double peso = pedirDatoDouble("Ingresa el peso en kg (ej: 2.5)", titulo);
        String salud;
        do {
             salud = pedirDato("Estado de salud (sano, enfermo, en observacion, vacunado)", titulo);
             if (!Pollo.estadoValido(salud)) {
                 mostrarError("Estado de salud invalido");
             }
        } while (!Pollo.estadoValido(salud));
        salud = salud.trim().toLowerCase();
        listaCorral.agregar(new Pollo(nombre, raza, edad, peso, salud));
        mostrarMensaje("Pollo registrado exitosamente.");
    }

    private void mostrarPollos(){
        if (listaCorral.vacia()) {
            mostrarMensaje("El corral esta vacio.");
            return;
        }
        mostrarDatos(listaCorral.mostrarPollos(), "Pollos en corral");
    }

    private void buscarPollo() throws CancelarException {
        String titulo = "Buscar Pollo";
        String id = pedirDato("Ingresa el ID del pollo a buscar",titulo);
        Pollo pollo = listaCorral.buscar(id);
        if (pollo == null) {
            mostrarAviso("No se encontro ningun pollo con ese ID.");
            return;
        }
        mostrarDatos(pollo.toString(), "Pollo con ID: " + id);
    }

    private void mostrarEnfermos(){
        if (listaCorral.vacia()) {
            mostrarAviso("El corral esta vacio.");
            return;
        }
        mostrarDatos(listaCorral.mostrarEnfermos(), "Pollos enfermos");
    }

    private void eliminarPollo() throws CancelarException {
        String titulo = "Eliminar Pollo";
        String id = pedirDato("Ingresa el ID del pollo a eliminar",titulo);
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
        String titulo = "Editar Pollo";
        String id = pedirDato("Ingresa el ID del pollo a modificar",titulo);
        if (listaCorral.buscar(id) == null) {
            mostrarAviso("No se encontro ningun pollo con ese ID.");
            return;
        }
        SubmenuEditar submenuEditar = new SubmenuEditar(listaCorral.buscar(id));
        submenuEditar.seleccionarOpcion();
    }

}