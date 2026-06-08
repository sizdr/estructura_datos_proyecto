package AlmacenHuevos;

import javax.swing.JOptionPane;

public class MenuAlmacenHuevos {

    private PilaHuevos pila;

    public MenuAlmacenHuevos() {
        pila = new PilaHuevos();
    }

    public void mostrar() {

        JOptionPane.showMessageDialog(
                null,
                "Módulo Almacén de Huevos cargado correctamente."
        );
    }

    public PilaHuevos getPila() {
        return pila;
    }
}