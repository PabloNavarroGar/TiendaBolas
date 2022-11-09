/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pablo;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class TiendaBolasPremios {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //variables
        int bola;
        double devolverImporte;
        String menu = "";
        double dinero = 0;
        double precioFinal;
        //Meotods
        menu = mostrarMenu();

        bola = generarBola();

        devolverImporte = importeCompra();

        precioFinal = descuentoPrecio(bola,devolverImporte);
    }

    public static String mostrarMenu() {

        String texto = """
                     -----------------------------------------------------
                      Bienvenido a al sorteo de nuestra tienda
                      Una ves saques la bola segun el colo obtendra una 
                      serie de descuentos
                     -----------------------------------------------------
                    """;

        System.out.println(texto);

        return texto;

    }

    public static int generarBola() {
        Random numeroAleatorio = new Random();

        int numeroBola = numeroAleatorio.nextInt(4) + 1;

        do {

            if (numeroBola == 1) {

                System.out.println("Has sacado la bola azul,obtienes un 20% de descuento");

            } else if (numeroBola == 2) {

                System.out.println("Has sacado la bola roja,obtienes un 25% de descuento");

            } else if (numeroBola == 3) {

                System.out.println("Has sacado la bola blanca, no tienes descuento");
            } else if (numeroBola == 4) {
                numeroBola = numeroAleatorio.nextInt(3) + 1;

                System.out.println("Has sacado la boola verde, vuelves a sacar otra bola");

                if (numeroBola == 1) {

                    System.out.println(" Has sacado la bola azul,,obtienes un 20% de descuento");
                } else if (numeroBola == 2) {
                    System.out.println(" Has sacado la bola roja,obtienes un 25% de descuento");

                } else if (numeroBola == 3) {

                    System.out.println("Has sacado la bola blanca, no tienes descuento");
                }

            }

        } while (numeroBola == 4);

        return numeroBola;
    }

    public static double importeCompra() {
        Scanner teclado = new Scanner(System.in);
        double importe = 0;
        boolean repetir = true;
        do{
        try {
            System.out.println("Introduzca el importe de su compra por favor");

            importe = teclado.nextDouble();

            System.out.println(" El importe de tu compra es de  " + importe);
            repetir = false;
        } catch (InputMismatchException ime) {
            System.out.println(" Precio no valido, vuelva a introducir el numero");
            teclado.nextLine();
        }
        }while(repetir);
        return importe;
    }

    public static double descuentoPrecio(int numeroBola,double importe) {
        double precioFinal = 0;
        
        

        if (numeroBola == 1) {

            precioFinal = (importe * 0.2);
            System.out.println("El precio que te descuentan es de " + precioFinal+"€");
        } else if (numeroBola == 2) {
            precioFinal = (importe * 0.25);
            System.out.println("El precio que te descontan es de   " + precioFinal+"€");
        } else if (numeroBola == 3) {

            System.out.println("No tienes descuento sigues pagando  " + importe);
        }

        return precioFinal;
    }
    
    
    
    
    
    
  
}
