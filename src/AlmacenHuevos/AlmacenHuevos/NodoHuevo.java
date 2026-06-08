package AlmacenHuevos;

public class NodoHuevo {

    Huevo dato;
    NodoHuevo siguiente;

    public NodoHuevo(Huevo dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}