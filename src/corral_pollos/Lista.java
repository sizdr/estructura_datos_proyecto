package corral_pollos;

import modelos.Pollo;

public class Lista {
    private Nodo cabeza;
    private int tamaño;
    private int contadorId;

    public Lista() {
        cabeza = null;
        tamaño = 0;
        contadorId = 1;
    }

    public boolean vacia() {
        return cabeza == null;
    }

    public String generarId() {
        String id = "P" + String.format("%03d", contadorId);;
        contadorId++;
        return id;
    }

    public void agregar(Pollo pollo) {
        Nodo nuevoNodo = new Nodo(pollo);
        nuevoNodo.getValor().setId(generarId());
        if (vacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public Pollo buscar(String id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().getId().equals(id)) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(String id) {
        if (vacia()) return false;

        if (cabeza.getValor().getId().equals(id)) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getValor().getId().equals(id)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean modificar(String id, Pollo nuevoValor) {
        Pollo pollo = buscar(id);
        if (pollo == null) return false;
        pollo.setNombre(nuevoValor.getNombre());
        pollo.setRaza(nuevoValor.getRaza());
        pollo.setEdad(nuevoValor.getEdad());
        pollo.setPeso(nuevoValor.getPeso());
        pollo.setEstadoSalud(nuevoValor.getEstadoSalud());
        return true;
    }

    public String mostrarPollos() {
        if (vacia()){
            return "El corral esta vacio.";
        }
        Nodo actual = cabeza;
        StringBuilder lista = new StringBuilder();
        while (actual != null) {
            lista.append(actual.getValor().toString()).append("\n").append("-------------------").append("\n");
            actual = actual.getSiguiente();
        }
        return lista.toString();
    }

    public String mostrarEnfermos() {
        Nodo actual = cabeza;
        StringBuilder enfermos = new StringBuilder();
        while (actual != null) {
            if (actual.getValor().getEstadoSalud().equalsIgnoreCase("enfermo")) {
                enfermos.append(actual.getValor().toString()).append("\n").append("------------------").append("\n");
            }
            actual = actual.getSiguiente();
        }
        if (enfermos.isEmpty()) {
            return "No hay pollos enfermos.";
        }
        return enfermos.toString();
    }

    public int getTamaño() {
        return tamaño;
    }

    public int totalEnfermos() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().getEstadoSalud().equalsIgnoreCase("enfermo")) {
                count++;
            }
            actual = actual.getSiguiente();
        }
        return count;
    }

    public int totalVacunados() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().getEstadoSalud().equalsIgnoreCase("vacunado")) {
                count++;
            }
            actual = actual.getSiguiente();
        }
        return count;
    }
}