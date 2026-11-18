package org.uabc.ic.modelo;

public class PezDorado extends Tamagochi implements  TamagochiActions{
    private int calidadAgua;
    private int controlTemperatura;
    private int oxigenacion;

    public PezDorado(String nombre, int energia, int hambre, int felicidad, int salud, int agua,
                     int controlTemperatura, int oxigenacion) {
        super(nombre, energia, hambre, felicidad, salud);
        this.calidadAgua=agua;
        this.controlTemperatura = controlTemperatura;
        this.oxigenacion = oxigenacion;

    }
    public void SalirNadar(){
        System.out.println("PezDorado nada alrededor de la pecera");
    }

    @Override
    public void comer(int alimento) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede comer.");
            return;
        }
        switch (alimento) {
            case 1 -> {
                IO.println(nombre + " come hojuelas");
                aplicarCambios(-30, 10, 3);
            }
            case 2 -> {
                IO.println(nombre + " come granulos");
                aplicarCambios(-15, 5, 10);
            }
            case 3 -> {
                IO.println(nombre + " devora un trozo de alga");
                aplicarCambios(-40, 20, 20);
            }
            default -> IO.println("Alimentos no validos para un pez dorado");
        }
    }

    @Override
    public int jugar(int tipoDeJuego) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede jugar.");
            return 0;
        }
        if (energia < 10) {
            IO.println(nombre + " esta muy cansado para jugar.");
            return 0;
        }
        int gasto;
        switch (tipoDeJuego) {
            case 1 -> {
                IO.println(nombre + " se esconde en su castillo.");
                gasto = 10;
                aplicarCambios(5, -gasto, 15);
            }
            case 2 -> {
                gasto = 5;
                aplicarCambios(3, -gasto, 10);
                SalirNadar();
            }
            case 3 -> {
                IO.println(nombre + "juega con su companiero.");
                gasto = 20;
                aplicarCambios(10, -gasto, 20);
            }
            default -> {
                IO.println("Esos juegos no estan solo esta 1 pelota, 2 perseguir cola, 3 correr).");
                gasto = 0;
            }
        }

        return gasto;
    }
    @Override
    public int dormir(int horasDeSueno) {
        int antes = energia;
        durmiendo = true;
        energia = limite(energia + horasDeSueno * 10);
        hambre = limite(hambre + horasDeSueno * 2);
        IO.println(nombre + " duerme " + horasDeSueno + " hora(s). Zzz...");
        return energia - antes;
    }

    @Override
    public String getMenuComida() {
        return "Selecciona el tipo de comida" +
                "1. Hojuelas" +
                "2. Granulos" +
                "3. Trozo de alga";
    }

    @Override
    public String getMenuJuegos() {
        return "Selecciona el tipo de juego" +
                "1. Esconder en el castillo" +
                "2. Salir a nadar" +
                "3. Jugar con su compañero";
    }

    @Override
    public void hacerSonido() {

    }

    @Override
    public void comportamientoEspecifico() {
    SalirNadar();
    }
    //getters y setters
    public int getCalidadAgua() {
        return calidadAgua;
    }
    public void setCalidadAgua(int calidadAgua) {
        this.calidadAgua = calidadAgua;
    }
    public int getControlTemperatura() {
        return controlTemperatura;
    }
    public void setControlTemperatura(int controlTemperatura) {
        this.controlTemperatura = controlTemperatura;
    }
    public int getOxigenacion() {
        return oxigenacion;
    }
    public void setOxigenacion(int oxigenacion) {
        this.oxigenacion = oxigenacion;
    }

}
