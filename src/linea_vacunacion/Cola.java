package linea_vacunacion;

import modelos.Pollo;

public class Cola {
    private NodoCola frente;
    private NodoCola fin;
    private int tamaño;
    private int vacunados;

    public Cola() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    public boolean vacia(){
        return frente == null;
    }

    public void encolar(Pollo pollo){
        NodoCola nuevoNodo = new NodoCola(pollo);
        if (vacia()){
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
          fin.setSiguiente(nuevoNodo);
          fin = nuevoNodo;
        }
        tamaño++;
        vacunados++;
    }

    public Pollo desencolar(){
        if (vacia()){
            return null;
        }
        Pollo polloAtendido = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null){
            fin = null;
        }
        tamaño--;
        return polloAtendido;
    }

    public String mostrarCola(){
        NodoCola actual = frente;
        StringBuilder pollosCola = new StringBuilder();
        while (actual != null){
            pollosCola.append(actual.getValor().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return pollosCola.toString();
    }

    public int getTamaño(){
        return tamaño;
    }

    public Pollo getFrente() {
        return frente.getValor();
    }

    public int getVacunados() {
        return vacunados;
    }
}
