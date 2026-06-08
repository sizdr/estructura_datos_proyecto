package AlmacenHuevos;

public class PilaHuevos {

    private NodoHuevo cima;
    private int contadorId;

    public PilaHuevos() {
        cima = null;
        contadorId = 1;
    }


    public String generarId() {
        String id = "H" + String.format("%03d", contadorId);;
        contadorId++;
        return id;
    }

    // PUSH
    public void registrarHuevo(Huevo huevo) {
        NodoHuevo nuevo = new NodoHuevo(huevo);
        nuevo.dato.setId(generarId());
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // POP
    public Huevo distribuirUltimoHuevo() {
        if (cima == null) {
            return null;
        }
        Huevo eliminado = cima.dato;
        cima = cima.siguiente;
        return eliminado;
    }

    // PEEK
    public Huevo consultarCima() {
        if (cima == null) {
            return null;
        }
        return cima.dato;
    }

    // ISEMPTY
    public boolean estaVacia() {
        return cima == null;
    }

    // MOSTRAR
    public String mostrarHuevos() {
        if (cima == null) {
            return "No hay huevos almacenados";
        }
        String texto = "";
        NodoHuevo aux = cima;
        while (aux != null) {
            texto += aux.dato.toString();
            texto += "\n-----------------\n";
            aux = aux.siguiente;
        }
        return texto;
    }

    // BUSCAR POR ID
    public Huevo buscarPorId(String id) {
        NodoHuevo aux = cima;
        while (aux != null) {
            if (aux.dato.getId().equals(id)) {
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    // MODIFICAR
    public boolean modificarHuevo(String id,
                                  String fecha,
                                  String tamano,
                                  double peso,
                                  String color,
                                  boolean disponible) {

        Huevo huevo = buscarPorId(id);
        if (huevo == null) {
            return false;
        }
        huevo.setFechaRecoleccion(fecha);
        huevo.setTamano(tamano);
        huevo.setPeso(peso);
        huevo.setColor(color);
        huevo.setDisponible(disponible);
        return true;
    }

    // ELIMINAR POR ID
    public boolean eliminarPorId(String id) {
        if (cima == null) {
            return false;
        }
        if (cima.dato.getId().equals(id)) {
            cima = cima.siguiente;
            return true;
        }
        NodoHuevo actual = cima;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.getId().equals(id)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // CONTAR HUEVOS
    public int totalHuevos() {
        int contador = 0;
        NodoHuevo aux = cima;
        while (aux != null) {
            contador++;
            aux = aux.siguiente;
        }
        return contador;
    }

    // PESO TOTAL
    public double pesoTotal() {
        double total = 0;
        NodoHuevo aux = cima;
        while (aux != null) {
            total += aux.dato.getPeso();
            aux = aux.siguiente;
        }
        return total;
    }
}