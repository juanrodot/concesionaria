
package concesionaria;

public abstract class Vehiculo implements DatosAdministrativos {
    public String marca;
    public String modelo;
    public String precio;

    

    public Vehiculo(String marca, String modelo, String precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    public abstract String queMarca();
    public abstract String queModelo();
}
