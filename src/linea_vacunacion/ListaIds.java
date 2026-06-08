package linea_vacunacion;

public class ListaIds {
    private NodoLista cabeza;

    public void agregar(String id) {
        NodoLista nuevo = new NodoLista(id);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public boolean contiene(String id) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(id)) return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void eliminar(String id) {
        if (cabeza == null) return;
        if (cabeza.getValor().equals(id)) {
            cabeza = cabeza.getSiguiente();
            return;
        }
        NodoLista actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getValor().equals(id)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
            actual = actual.getSiguiente();
        }
    }
}
