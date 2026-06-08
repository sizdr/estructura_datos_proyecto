package AlmacenHuevos;

public class Huevo {

    private String id;
    private String fechaRecoleccion;
    private String tamano;
    private double peso;
    private String color;
    private boolean disponible;

    public Huevo(String fechaRecoleccion, String tamano, double peso, String color) {
        this.id = null;
        this.fechaRecoleccion = fechaRecoleccion;
        this.tamano = tamano;
        this.peso = peso;
        this.color = color;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRecoleccion(String fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nFecha: " + fechaRecoleccion +
                "\nTamaño: " + tamano +
                "\nPeso: " + peso +
                "\nColor: " + color +
                "\nDisponible: " + disponible;
    }
}