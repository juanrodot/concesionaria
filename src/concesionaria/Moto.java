
package concesionaria;

public class Moto extends Vehiculo implements DatosAdministrativos {
    private String cilindrada ;
    
    public Moto( String marca, String modelo,String cilindrada, String precio) {
        super(marca, modelo,precio);
        this.cilindrada = cilindrada;
        
    }

    @Override
    public String queMarca() {
        return this.marca;
    }

    @Override
    public String queModelo() {
      return this.modelo;
    }

    @Override
    public double precioNum() {
         return  Double.parseDouble((this.precio.replace(".", "")).replace(",", "."));
    }
    
    @Override
    public String toString(){ //sobreescribo el toString
        return "Marca: "+this.marca+" // Modelo: "+this.modelo+ " // Cilindrada: "+this.cilindrada+ " // precio: $"+getPrecio();
        //Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: $60.000,00
    } 
    
    //getters y setters

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    

     
}
