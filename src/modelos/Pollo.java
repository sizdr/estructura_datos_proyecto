package modelos;

public class Pollo {
    private String id;
    private String nombre;
    private String raza;

    //Edad en meses
    private int edad;
    private double peso;


    private String estado_salud;
    private boolean activo;

    public Pollo(String id, String nombre, String raza, int edad, double peso, String estado_salud, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.estado_salud = estado_salud;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstado_salud() {
        return estado_salud;
    }

    public void setEstado_salud(String estado_salud) {
        this.estado_salud = estado_salud;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "  Nombre: " + nombre +
                " Raza: " + raza +
                "Edad: " + edad + " meses" +
                " Peso: " + peso + " kg" +
                " Salud: " + estado_salud +
                " Activo: " + activo;
    }
}