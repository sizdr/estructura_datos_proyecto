package linea_vacunacion;

import modelos.Pollo;

public class Nodo {
    private Pollo valor;
    private Nodo siguiente;

    Nodo(Pollo valor){
        this.valor = valor;
        this.siguiente = null;
    }
    public Pollo getValor() {
        return valor;
    }
    public void setValor(Pollo valor) {
        this.valor = valor;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
