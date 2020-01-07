
package concesionaria;

public class Auto extends Vehiculo implements DatosAdministrativos  {
    private int cantDePuertas;
   

    public Auto(String marca,String modelo,int cantDePuertas, String precio) {
        super(marca,modelo,precio);
        this.cantDePuertas = cantDePuertas;
    
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
        return "Marca: "+this.marca+" // Modelo: "+this.modelo+ " // Puertas: "+this.cantDePuertas+ " // precio: $"+this.precio;
        // Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00
    }
    
    
 // getter y setters
    public int getCantDePuertas() {
        return cantDePuertas;
    }

    public void setCantDePuertas(int cantDePuertas) {
        this.cantDePuertas = cantDePuertas;
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
