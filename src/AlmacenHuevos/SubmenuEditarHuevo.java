package AlmacenHuevos;

import menus.CancelarException;
import menus.Menu;

import javax.swing.*;

public class SubmenuEditarHuevo extends Menu {
    private Huevo huevoActual;

    public SubmenuEditarHuevo(Huevo huevo) {
        this.huevoActual = huevo;
    }

    @Override
    protected String getOpciones() {
        return """
                EDITAR HUEVO\n
                """ +
                huevoActual.toString() +
                """
                \n
                OPCIONES
                1. Editar fecha de recolección
                2. Editar tamaño
                3. Editar peso
                4. Editar color
                5. Editar disponibilidad
                6. Salir
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> editarFecha();
            case 2 -> editarTamano();
            case 3 -> editarPeso();
            case 4 -> editarColor();
            case 5 -> editarDisponibilidad();
            case 6 -> cerrarMenu = true;
            default -> mostrarError("Opción no válida.");
        }
        return cerrarMenu;
    }

    private void editarFecha() throws CancelarException {
        String nueva = pedirDato("Ingresa la nueva fecha de recolección (dd/mm/aaaa)",
                "Editar fecha", huevoActual.getFechaRecoleccion());
        huevoActual.setFechaRecoleccion(nueva);
        mostrarMensaje("Fecha de recolección actualizada.");
    }

    private void editarTamano() throws CancelarException {
        String nuevo = pedirDato("Ingresa el nuevo tamaño (pequeño, mediano, grande)",
                "Editar tamaño", huevoActual.getTamano());
        huevoActual.setTamano(nuevo);
        mostrarMensaje("Tamaño actualizado.");
    }

    private void editarPeso() throws CancelarException {
        double nuevo = pedirDatoDouble("Ingresa el nuevo peso en kg (ej: 0.06)",
                "Editar peso", huevoActual.getPeso());
        huevoActual.setPeso(nuevo);
        mostrarMensaje("Peso actualizado.");
    }

    private void editarColor() throws CancelarException {
        String nuevo = pedirDato("Ingresa el nuevo color",
                "Editar color", huevoActual.getColor());
        huevoActual.setColor(nuevo);
        mostrarMensaje("Color actualizado.");
    }

    private void editarDisponibilidad() {
        int resp = JOptionPane.showConfirmDialog(null,
                "¿El huevo está disponible?", "Editar disponibilidad", JOptionPane.YES_NO_OPTION);
        huevoActual.setDisponible(resp == JOptionPane.YES_OPTION);
        mostrarMensaje("Disponibilidad actualizada.");
    }
}

