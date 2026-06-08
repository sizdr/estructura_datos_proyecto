import corral_pollos.Lista;
import corral_pollos.MenuCorral;
import linea_vacunacion.Cola;
import linea_vacunacion.MenuVacunacion;
import modelos.Pollo;

import javax.swing.*;

void main() {
    Cola cola = new Cola();
    Lista listaCorral =  new Lista();

    MenuCorral menuCorral =  new MenuCorral(listaCorral);
    MenuVacunacion menuVacunacion = new MenuVacunacion(cola, listaCorral);
    MenuReporte menuReporte = new MenuReporte(listaCorral, cola);

    MenuPrincipal menuPrincipal = new MenuPrincipal(menuCorral, menuVacunacion, menuReporte);

    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"sano"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"enfermo"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"enfermo"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"enfermo"));
    listaCorral.agregar(new Pollo("Daniel","Albino",6,2.2,"sano"));

    menuPrincipal.seleccionarOpcion();
}
