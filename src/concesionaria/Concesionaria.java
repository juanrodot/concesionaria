package concesionaria;

public class Concesionaria {

    public static void main(String[] args) {
        //EJERCICIO 1
        Vehiculo[] stock = stock();
        listaStock(stock);
        int[] g = ordenar(stock);
        System.out.println("---------------------------------------------");
        masCaro(g, stock);
        masBarato(g, stock);
        buscarLetra(stock);
        //EJERCICIO 2
        System.out.println("---------------------------------------------");
        ordenMayorMenor(g,stock);
        System.exit(0);
    }

    public static Vehiculo[] stock() {
        Vehiculo[] stock = new Vehiculo[4]; //podria ir con un arraylist tambien
        stock[0] = new Auto("Peugeot", "206", 4, "200.000,00");
        stock[1] = new Moto("Honda", "Titan", "125c", "60.000,00");
        stock[2] = new Auto("Peugeot", "208", 5, "250.000,00");
        stock[3] = new Moto("Yamaha", "YBR", "160c", "80.500,50");
        return stock;
        /*Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: $200.000,00
          Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: $60.000,00
          Marca: Peugeot // Modelo: 208 // Puertas: 5 // Precio: $250.000,00
          Marca: Yamaha // Modelo: YBR // Cilindrada: 160c // Precio: $80.500,50
         */
    }

    //Armo la lista de todos los autos y motos
    public static void listaStock(Vehiculo[] stock) {
        for (int i = 0; i < stock.length; i++) {
            System.out.println(stock[i]);
        }
    }

    public static int[] ordenar(Vehiculo[] stock) {
        //lo hago asi para no usar un ArrayList y un Iterator 
        int[] g = new int[stock.length]; //uso un array para ordenar las posiciones de los objetos
        for (int i = 0; i < stock.length; i++) {//le asigno valores al array para que no tengan caracteres vacios y poder ordenarlos
            g[i] = i;
        }
        int aux;
        for (int i = 0; i < stock.length - 1; i++) {
            for (int j = 0; j < stock.length - i - 1; j++) {
                //parseo los valores que originalmente son String a double para poder compararlos
                double valor = stock[g[j]].precioNum();
                double valorSig = stock[g[j + 1]].precioNum();
                if (valorSig < valor) { //ordeno segun su valor de menor a mayor
                    aux = g[j + 1];
                    g[j + 1] = g[j];
                    g[j] = aux;
                }
            }
        }//ahora las posiciones del orden estan guardadas en g[]      
        return g;

    } //se crea un array que representa el stock en orden

    public static void masCaro(int[] g, Vehiculo[] stock) {
        int menor, mayor, letra;
        System.out.print("Vehiculo mas caro: " + stock[g[stock.length - 1]].queMarca() + " " + stock[g[stock.length - 1]].queModelo());
        //este for se fija si hay mas autos de igual precio y los mostraria tambien
        for (int i = 0; i < stock.length - 1; i++) {
            if (stock[g[stock.length - 1 - i]].precioNum() == stock[g[stock.length - 2 - i]].precioNum()) {
                System.out.print("/" + stock[g[stock.length - 2 - i]].queMarca() + " " + stock[g[stock.length - 2 - i]].queModelo());
            } else {
                break;
            }
        }
        System.out.println(""); //para bajar una linea(en el caso de tener varios autos con precio mayor)
    }

    public static void masBarato(int[] g, Vehiculo[] stock) {
        int menor, mayor, letra;
        System.out.print("Vehiculo mas barato: " + stock[g[0]].queMarca() + " " + stock[g[0]].queModelo());
        //este for se fija si hay mas autos de igual precio y los mostraria tambien
        for (int i = 0; i < stock.length - 1; i++) {
            if (stock[g[i]].precioNum() == stock[g[i + 1]].precioNum()) {
                System.out.print("/" + stock[g[i + 1]].queMarca() + " " + stock[g[i + 1]].queModelo());
            } else {
                break;
            }
        }
        System.out.println(""); //para bajar una linea(en el caso de tener varios autos con precio menor)
    }

    public static void buscarLetra(Vehiculo[] stock) {
        System.out.print("Vehiculo que contiene en el modelo la letra 'Y' : ");
        for (int i = 0; i < stock.length; i++) {
            String modelo = stock[i].queModelo();
            for (int j = 0; j < modelo.length(); j++) {
                if (modelo.charAt(j) == 'Y' || modelo.charAt(j) == 'y') {
                    System.out.println(stock[i].queMarca() + " " + stock[i].queModelo() + " $" + stock[i].precio);
                }
            }
        }
    }
    
    public static void ordenMayorMenor(int[] g,Vehiculo[] stock){
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        for (int i = stock.length-1; i >= 0; i--) { 
            System.out.println(stock[g[i]].queMarca()+" "+stock[g[i]].queModelo());
        }
    }
    
}
