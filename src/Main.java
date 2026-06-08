import AlmacenHuevos.Huevo;
import AlmacenHuevos.MenuAlmacenHuevos;
import AlmacenHuevos.PilaHuevos;
import corral_pollos.Lista;
import corral_pollos.MenuCorral;
import linea_vacunacion.Cola;
import linea_vacunacion.MenuVacunacion;
import modelos.Pollo;

import javax.swing.*;

void main() {
    Cola cola = new Cola();
    Lista listaCorral =  new Lista();
    PilaHuevos pilaHuevos = new PilaHuevos();

    MenuCorral menuCorral =  new MenuCorral(listaCorral);
    MenuVacunacion menuVacunacion = new MenuVacunacion(cola, listaCorral);
    MenuAlmacenHuevos menuAlmacenHuevos = new MenuAlmacenHuevos(pilaHuevos);
    MenuReporte menuReporte = new MenuReporte(listaCorral, cola, pilaHuevos);

    MenuPrincipal menuPrincipal = new MenuPrincipal(menuCorral, menuVacunacion, menuReporte, menuAlmacenHuevos);

    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"sano"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"enfermo"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"sano"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"en observacion"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"sano"));

    pilaHuevos.registrarHuevo(new Huevo("08/06/2005", "Chico", 12, "Blanco"));
    pilaHuevos.registrarHuevo(new Huevo("08/06/2005", "Mediano", 16, "Blanco"));
    pilaHuevos.registrarHuevo(new Huevo("09/06/2005", "Mediano", 18, "Blanco"));
    pilaHuevos.registrarHuevo(new Huevo("11/06/2005", "Mediano", 14, "Cafe"));

    menuPrincipal.seleccionarOpcion();
}
