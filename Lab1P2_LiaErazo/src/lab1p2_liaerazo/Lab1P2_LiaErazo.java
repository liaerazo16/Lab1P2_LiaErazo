/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_liaerazo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Paola
 */
public class Lab1P2_LiaErazo {
    //scanner read para strings
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        do {
            System.out.println("\nIngrese el tamaño de matriz deseado :");
            int size = leer.nextInt();
            if (size % 2 == 0 && size <= 4) {
                System.out.println("Ingrese un numero impar mayot que 4");
                return;
            }
            int[][] matriz = Generar(size);
            System.out.println("Matriz generada :");
            Imprimir(matriz);

        } while (seguir);
    }//main

    public static int[][] Generar(int size) {
        int[][] matriz = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }
        return matriz;
    }

    public static void Imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static void BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[j + 1]) {
                    int X = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = X;
                }
            }
        }
    }
    
     public static void Ordenadamiento(int[][]matriz){
         for (int i = 0; i < matriz.length; i++) {
             BubbleSort(matriz[i]);
         }
    }
     
}
