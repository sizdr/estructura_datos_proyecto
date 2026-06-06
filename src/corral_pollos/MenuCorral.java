package corral_pollos;

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
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                String id = pedirDato("Ingresa el ID del pollo (ej: P001)");
                if (listaCorral.buscarPorId(id) != null) {
                    mostrarMensaje("Error: Ya existe un pollo con ese ID.");
                    break;
                }
                String nombre = pedirDato("Ingresa el nombre del pollo");
                String raza = pedirDato("Ingresa la raza del pollo");
                int edad = pedirDatoNumerico("Ingresa la edad en meses");
                double peso = pedirDatoDouble("Ingresa el peso en kg (ej: 2.5)");
                String salud = pedirDato("Estado de salud (sano, enfermo, en observacion, vacunado)");
                listaCorral.agregar(new Pollo(id, nombre, raza, edad, peso, salud, true));
                mostrarMensaje("Pollo registrado exitosamente.");
                break;

            case 2:
                if (listaCorral.vacia()) {
                    mostrarMensaje("El corral esta vacio.");
                } else {
                    mostrarMensaje(listaCorral.mostrarPollos());
                }
                break;

            case 3:
                String buscarId = pedirDato("Ingresa el ID del pollo a buscar");
                Pollo encontrado = listaCorral.buscarPorId(buscarId);
                if (encontrado == null) {
                    mostrarMensaje("No se encontro ningun pollo con ese ID.");
                } else {
                    mostrarMensaje(encontrado.toString());
                }
                break;

            case 4:
                if (listaCorral.vacia()) {
                    mostrarMensaje("El corral esta vacio.");
                } else {
                    mostrarMensaje(listaCorral.mostrarEnfermos());
                }
                break;

            case 5:
                String modId = pedirDato("Ingresa el ID del pollo a modificar");
                if (listaCorral.buscarPorId(modId) == null) {
                    mostrarMensaje("No se encontro ningun pollo con ese ID.");
                    break;
                }
                String nuevoNombre = pedirDato("Nuevo nombre");
                String nuevaRaza = pedirDato("Nueva raza");
                int nuevaEdad = pedirDatoNumerico("Nueva edad en meses");
                double nuevoPeso = pedirDatoDouble("Nuevo peso en kg");
                String nuevaSalud = pedirDato("Nuevo estado de salud");
                listaCorral.modificar(modId, nuevoNombre, nuevaRaza, nuevaEdad, nuevoPeso, nuevaSalud);
                mostrarMensaje("Pollo modificado exitosamente.");
                break;

            case 6:
                String elimId = pedirDato("Ingresa el ID del pollo a eliminar");
                if (listaCorral.buscarPorId(elimId) == null) {
                    mostrarMensaje("No se encontro ningun pollo con ese ID.");
                    break;
                }
                int confirmar = JOptionPane.showConfirmDialog(null,
                        "¿Estas seguro de eliminar este pollo?", "Confirmar",
                        JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    listaCorral.eliminar(elimId);
                    mostrarMensaje("Pollo eliminado exitosamente.");
                } else {
                    mostrarMensaje("Operacion cancelada.");
                }
                break;

            case 7:
                mostrarMensaje("Regresando al menu principal");
                break;

            default:
                mostrarMensaje("Opcion no valida.");
                break;
        }
    }

}