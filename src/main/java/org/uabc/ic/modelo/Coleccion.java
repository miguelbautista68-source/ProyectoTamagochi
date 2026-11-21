package org.uabc.ic.modelo;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Tamagochi> misJueguetes;

    public Coleccion(){
        misJueguetes = new ArrayList<>();
    }

    public void agregar(Tamagochi t){
        misJueguetes.add(t);
    }

    public String listaJuguetes(){
        StringBuffer cadena = new StringBuffer();
        for(Tamagochi t : misJueguetes){
            cadena.append(t);
        }
        return cadena.toString();
    }

    // Lista con el nombre y el tipo de cada tamagochi registrado
    public String listaNombres() {
        if (misJueguetes.isEmpty()) {
            return "No hay tamagochis registrados todavia.";
        }
        StringBuilder cadena = new StringBuilder("Tamagochis activos:\n");
        for (Tamagochi t : misJueguetes) {
            cadena.append("- ")
                  .append(t.getNombre())
                  .append(" (")
                  .append(t.getClass().getSimpleName())
                  .append(")\n");
        }
        return cadena.toString();
    }

    public Tamagochi buscarTamagochi(String encontrar){
        return misJueguetes.stream()
                .filter(n -> n.getNombre().equalsIgnoreCase(encontrar))
                .findFirst()
                .orElse(null);
    }

    public void pasarTiempoATodos() {
        for (Tamagochi t : misJueguetes) {
            t.pasoDelTiempo();
        }
    }

    // Quita de la lista a los tamagochis que ya murieron
    public void eliminarMuertos() {
        for (int i = misJueguetes.size() - 1; i >= 0; i--) {
            Tamagochi t = misJueguetes.get(i);
            if (t.morir()) {
                IO.println(t.getNombre() + " murio y fue eliminado");
                misJueguetes.remove(i);
            }
        }
    }

    public void agregarPerro(String nombre, int energia, int hambre, int felicidad, int salud, int agresividad, int imper){
        agregar (new Perro(nombre,energia ,hambre, felicidad, salud, agresividad, imper));
    }

    public void agregarPerDorado (String nombre, int energia, int hambre, int felicidad, int salud, int agua,
                                  int controlTemperatura, int oxigenacion){
        agregar(new PezDorado(nombre, energia, hambre, felicidad, salud, agua, controlTemperatura, oxigenacion));
    }

    public void agregarAguila(String nombre, int energia, int hambre, int felicidad, int salud, int fuerza,  int velocidad){
        agregar (new Aguila(nombre, energia, hambre, felicidad, salud, fuerza,  velocidad));
    }

    public void agregarDragon(String nombre, int energia, int hambre, int felicidad, int salud, int tamanio, boolean tirarFuego, int apetito){
        agregar(new Dragon(nombre, energia, hambre, felicidad, salud, tamanio, tirarFuego, apetito));
    }

}
