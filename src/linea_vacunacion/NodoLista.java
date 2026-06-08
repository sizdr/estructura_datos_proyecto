package linea_vacunacion;

public class NodoLista {
        private String valor;
        private NodoLista siguiente;

        public NodoLista(String valor) {
            this.valor = valor;
            this.siguiente = null;
        }

        public String getValor() { return valor; }
        public NodoLista getSiguiente() { return siguiente; }
        public void setSiguiente(NodoLista siguiente) { this.siguiente = siguiente; }

}
