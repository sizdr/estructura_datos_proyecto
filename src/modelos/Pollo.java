package modelos;

public class Pollo {
    private String id;
    private String nombre;
    private String raza;

    //Edad en meses
    private int edad;
    private double peso;


    private String estadoSalud;
    private boolean activo;

    Pollo(){}

    public Pollo(String nombre, String raza, int edad, double peso, String estado_salud) {
        this.id = null;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.estadoSalud = estado_salud;
        this.activo = true;
    }

    public static boolean estadoValido(String estado){
        if (estado.equalsIgnoreCase("sano")){
            return true;
        }
        if (estado.equalsIgnoreCase("enfermo")){
            return true;
        }
        if (estado.equalsIgnoreCase("en observacion")){
            return true;
        }
        return estado.equalsIgnoreCase("vacunado");
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

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
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
                "\nNombre: " + nombre +
                "\nRaza: " + raza +
                "\nEdad: " + edad + " meses" +
                "\nPeso: " + peso + " kg" +
                "\nSalud: " + estadoSalud +
                "\nActivo: " + (activo? "Si":"No");
    }
}