package linea_vacunacion;

import corral_pollos.Lista;
import menus.CancelarException;
import menus.Menu;
import modelos.Pollo;

public class MenuVacunacion extends Menu {
    private Cola colaVacunacion;
    private Lista listaVacunacion;
    private ListaIds idsEnFila;

    public MenuVacunacion(Cola colaVacunacion, Lista listaVacunacion) {
        this.colaVacunacion = colaVacunacion;
        this.listaVacunacion = listaVacunacion;
        this.idsEnFila = new ListaIds();
    }

    @Override
    protected String getOpciones() {
        return """
                LÍNEA DE VACUNACIÓN\s
                
                1. Formar pollo para vacunación
                2. Vacunar siguiente pollo 
                3. Consultar siguiente pollo en la fila
                4. Mostrar fila de vacunación
                5. Verificar si la fila está vacía
                6. Regresar al menu principal
                """;
    }

    @Override
    protected boolean procesarOpcion(int opcion) throws CancelarException {
        boolean cerrarMenu = false;
        switch (opcion) {
            case 1 -> formarPollo();
            case 2 -> vacunarPollo();
            case 3 -> consultarSiguiente();
            case 4 -> mostrarCola();
            case 5 -> verificarFilaVacia();
            case 6 -> cerrarMenu = true;
            default -> mostrarError("Opcion invalida");
        }
        return cerrarMenu;
    }

    private void formarPollo() throws CancelarException {
        String id = pedirDato("Ingrese el ID del pollo", "Fila para vacunacion"
        );
        Pollo pollo = listaVacunacion.buscar(id);
        if (pollo == null) {
            mostrarError("Pollo no encontrado");
            return;
        }
        if (idsEnFila.contiene(pollo.getId())) {
            mostrarError("El pollo ya se encuentra en fila");
            return;
        }
        if (!pollo.getEstadoSalud().equalsIgnoreCase("Sano")){
            mostrarError("Debido a su estado de salud el pollo no puede ser agregado a la fila");
            return;
        }
        colaVacunacion.encolar(pollo);
        idsEnFila.agregar(pollo.getId());
        mostrarMensaje("Pollo agregado a la fila de vacunacion");
    }

    public void vacunarPollo(){
        if (colaVacunacion.vacia()){
            mostrarMensaje("No hay ningun pollo en fila de vacunacion");
            return;
        }
        Pollo frente = colaVacunacion.getFrente();
        frente.setEstadoSalud("Vacunado");
        colaVacunacion.desencolar();
        idsEnFila.eliminar(frente.getId());
        mostrarMensaje("Pollo con ID " + frente.getId() + " vacunado con exito" );

    }

    public void consultarSiguiente(){
        if (colaVacunacion.vacia()){
            mostrarMensaje("No hay ningun pollo en fila de vacunacion");
            return;
        }
        mostrarDatos(colaVacunacion.getFrente().toString(), "Proximo pollo a vacunar");
    }

    public void mostrarCola(){
        if (colaVacunacion.vacia()){
            mostrarMensaje("No hay ningun pollo en fila de vacunacion");
            return;
        }
        mostrarDatos(colaVacunacion.mostrarCola(), "Fila para vacunacion");
    }

    public void verificarFilaVacia(){
        if (colaVacunacion.vacia()){
            mostrarMensaje("La fila de vacunacion esta vacia");
        } else {
            mostrarMensaje("la fila de vacunacion no esta vacia");
        }
    }
}
