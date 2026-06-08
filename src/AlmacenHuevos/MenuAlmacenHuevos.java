package AlmacenHuevos;

import menus.CancelarException;
import menus.Menu;

import javax.swing.JOptionPane;

public class MenuAlmacenHuevos extends Menu {

    private PilaHuevos pilaHuevos;

    public MenuAlmacenHuevos(PilaHuevos pilaHuevos) {
        this.pilaHuevos = pilaHuevos;
    }

    @Override
    protected String getOpciones() {
        return """
                ALMACÉN DE HUEVOS
                
                1. Registrar huevo recolectado
                2. Distribuir último huevo recolectado
                3. Consultar huevo en la cima
                4. Mostrar huevos almacenados
                5. Buscar huevo por ID
                6. Modificar datos de un huevo
                7. Eliminar huevo por ID
                8. Verificar si el almacén está vacío
                9. Regresar al menú principal
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> registrarHuevo();
            case 2 -> distribuirUltimo();
            case 3 -> consultarCima();
            case 4 -> mostrarHuevos();
            case 5 -> buscarHuevo();
            case 6 -> modificarHuevo();
            case 7 -> eliminarHuevo();
            case 8 -> verificarVacio();
            case 9 -> cerrarMenu = true;
            default -> mostrarError("Opción no válida.");
        }
        return cerrarMenu;
    }

    private void registrarHuevo() throws CancelarException, CancelarException {
        String titulo = "Registrar Huevo";
        String fecha = pedirDato("Ingresa la fecha de recolección (dd/mm/aaaa)", titulo);
        String tamano = pedirDato("Ingresa el tamaño (pequeño, mediano, grande)", titulo);
        double peso = pedirDatoDouble("Ingresa el peso en kg (ej: 0.06)", titulo);
        String color = pedirDato("Ingresa el color del huevo", titulo);
        Huevo huevo = new Huevo(fecha, tamano, peso, color);
        pilaHuevos.registrarHuevo(huevo);
        mostrarMensaje("Huevo registrado exitosamente.");
    }

    private void distribuirUltimo() {
        if (pilaHuevos.estaVacia()) {
            mostrarAviso("El almacén está vacío. No hay huevos para distribuir.");
            return;
        }
        Huevo huevo = pilaHuevos.distribuirUltimoHuevo();
        mostrarMensaje("Huevo distribuido:\n\n" + huevo.toString());
    }

    private void consultarCima() {
        if (pilaHuevos.estaVacia()) {
            mostrarAviso("El almacén está vacío.");
            return;
        }
        Huevo huevo = pilaHuevos.consultarCima();
        mostrarDatos(huevo.toString(), "Huevo en la cima");
    }

    private void mostrarHuevos() {
        if (pilaHuevos.estaVacia()) {
            mostrarMensaje("El almacén está vacío.");
            return;
        }
        mostrarDatos(pilaHuevos.mostrarHuevos(), "Huevos almacenados");
    }

    private void buscarHuevo() throws CancelarException {
        String titulo = "Buscar Huevo";
        String id = pedirDato("Ingresa el ID del huevo a buscar", titulo);
        Huevo huevo = pilaHuevos.buscarPorId(id);
        if (huevo == null) {
            mostrarAviso("No se encontró ningún huevo con ese ID.");
            return;
        }
        mostrarDatos(huevo.toString(), "Huevo con ID: " + id);
    }

    private void modificarHuevo() throws CancelarException {
        String titulo = "Modificar Huevo";
        String id = pedirDato("Ingresa el ID del huevo a modificar", titulo);
        Huevo huevo = pilaHuevos.buscarPorId(id);
        if (huevo == null) {
            mostrarAviso("No se encontró ningún huevo con ese ID.");
            return;
        }
        SubmenuEditarHuevo submenu = new SubmenuEditarHuevo(huevo);
        submenu.seleccionarOpcion();
    }

    private void eliminarHuevo() throws CancelarException {
        String titulo = "Eliminar Huevo";
        String id = pedirDato("Ingresa el ID del huevo a eliminar", titulo);
        if (pilaHuevos.buscarPorId(id) == null) {
            mostrarError("No se encontró ningún huevo con ese ID.");
            return;
        }
        int confirmar = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar este huevo?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            pilaHuevos.eliminarPorId(id);
            mostrarMensaje("Huevo eliminado exitosamente.");
        } else {
            mostrarAviso("Operación cancelada.");
        }
    }

    private void verificarVacio() {
        if (pilaHuevos.estaVacia()) {
            mostrarMensaje("El almacén está vacío.");
        } else {
            mostrarMensaje("El almacén tiene " + pilaHuevos.totalHuevos() + " huevo(s) almacenado(s).");
        }
    }
}
