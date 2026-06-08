package linea_vacunacion;

import modelos.Pollo;

public class NodoCola {
    private Pollo valor;
    private NodoCola siguiente;

    NodoCola(Pollo valor){
        this.valor = valor;
        this.siguiente = null;
    }
    public Pollo getValor() {
        return valor;
    }
    public void setValor(Pollo valor) {
        this.valor = valor;
    }
    public NodoCola getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
