package corral_pollos;

import modelos.Pollo;

public class Lista {
    private Nodo cabeza;
    private int tamaño;

    public Lista() {
        cabeza = null;
        tamaño = 0;
    }

    public boolean vacia() {
        return cabeza == null;
    }

    public void agregar(Pollo pollo) {
        Nodo nuevoNodo = new Nodo(pollo);
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

    public boolean modificar(String id, String nombre, String raza, int edad, double peso, String estado_salud) {
        Pollo pollo = buscar(id);
        if (pollo == null) return false;
        pollo.setNombre(nombre);
        pollo.setRaza(raza);
        pollo.setEdad(edad);
        pollo.setPeso(peso);
        pollo.setEstado_salud(estado_salud);
        return true;
    }

    public String mostrarPollos() {
        if (vacia()) return "El corral esta vacio.";
        Nodo actual = cabeza;
        StringBuilder lista = new StringBuilder();
        while (actual != null) {
            lista.append(actual.getValor().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return lista.toString();
    }

    public String mostrarEnfermos() {
        Nodo actual = cabeza;
        StringBuilder enfermos = new StringBuilder();
        while (actual != null) {
            if (actual.getValor().getEstado_salud().equalsIgnoreCase("enfermo")) {
                enfermos.append(actual.getValor().toString()).append("\n");
            }
            actual = actual.getSiguiente();
        }
        if (enfermos.length() == 0) return "No hay pollos enfermos.";
        return enfermos.toString();
    }

    public int getTamaño() {
        return tamaño;
    }

    public int totalEnfermos() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().getEstado_salud().equalsIgnoreCase("enfermo")) {
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
            if (actual.getValor().getEstado_salud().equalsIgnoreCase("vacunado")) {
                count++;
            }
            actual = actual.getSiguiente();
        }
        return count;
    }
}