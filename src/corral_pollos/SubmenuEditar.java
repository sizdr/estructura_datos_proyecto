package corral_pollos;

import menus.CancelarException;
import menus.Menu;
import modelos.Pollo;

public class SubmenuEditar extends Menu {
    Pollo polloActual;

    SubmenuEditar(Pollo pollo) {
        this.polloActual = pollo;
    }

    @Override
    protected String getOpciones() {
        return """
                EDITAR POLLO\n
                """ +
                polloActual.toString() +
                """
                \n
                OPCIONES
                1. Editar nombre
                2. Editar raza
                3. Editar edad
                4. Editar peso
                5. Editar estado de salud
                6. Salir
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> editarNombre();
            case 2 -> editarRaza();
            case 3 -> editarEdad();
            case 4 -> editarPeso();
            case 5 -> editarEstado();
            case 6 -> cerrarMenu = true;
            default ->mostrarError("Opcion no valida.");
        }
        return cerrarMenu;
    }

    public void editarNombre() throws CancelarException {
        String nuevoNombre = pedirDato("Ingresa el nuevo nombre", "Editar nombre", polloActual.getNombre());
        polloActual.setNombre(nuevoNombre);
        mostrarMensaje("Nombre de pollo actualizado");
    }

    public void editarRaza() throws CancelarException {
        String nuevaRaza = pedirDato("Ingresa la nueva raza", "Editar raza", polloActual.getRaza());
        polloActual.setNombre(nuevaRaza);
        mostrarMensaje("Raza de pollo actualizada");
    }

    public void editarEdad() throws CancelarException {
        int edad = pedirDatoNumerico("Ingresa el nuevo peso", "Editar peso", polloActual.getEdad());
        polloActual.setEdad(edad);
        mostrarMensaje("Edad de pollo actualizada");
    }

    public void editarPeso() throws CancelarException {
        double peso = pedirDatoDouble("Ingresa el peso", "Editar peso", polloActual.getPeso());
        polloActual.setPeso(peso);
        mostrarMensaje("Peso de pollo actualizada");
    }

    public void editarEstado() throws CancelarException {
        String salud = pedirDato("Ingrese el nuevo estado de salud (sano, enfermo, en observacion, vacunado)", "Editar estado de salud");
        if (!Pollo.estadoValido(salud)) {
            mostrarError("Estado de salud invalido");
            return;
        }
        mostrarMensaje("Estado de salud actualizado");

    }
}
