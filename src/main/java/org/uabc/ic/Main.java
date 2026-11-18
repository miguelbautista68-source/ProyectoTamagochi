package org.uabc.ic;

import org.uabc.ic.VIsta.VistaConsola;
import org.uabc.ic.control.Controlador;
import org.uabc.ic.modelo.Coleccion;
import org.uabc.ic.modelo.Tamagochi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Controlador controlador;
        Coleccion modelo = new Coleccion();
        VistaConsola vista = new VistaConsola();

        Controlador controlador1 = new Controlador(vista, modelo);

        controlador1.iniciar();
    }
}
