/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_liaerazo;

import java.util.ArrayList;
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
            System.out.println("Ingrese el tamaño de matriz deseado :");
            int size = leer.nextInt();
            if (size % 2 == 0 && size <= 4) {
                System.out.println("\nIngrese un numero impar mayot que 4");
                return;
            }
            int[][] matriz = Generar(size);
            System.out.println("\nMatriz generada:");
            Imprimir(matriz);
            System.out.println("\nMatriz ordenada:");
            Ordenamiento(matriz);
            Imprimir(matriz);
            System.out.println("\nArreglo de medianas:");
            ArrayList<Integer> medianas = ArrayMedians(matriz);
            for (int i = 0; i < medianas.size(); i++) {
                System.out.print("["+medianas.get(i)+"]");
            }
            System.out.println("\nArreglo de medianas ordenado:");
            BubbleSortArrayList(medianas);
            for (int i = 0; i < medianas.size(); i++) {
                System.out.print("["+medianas.get(i)+"]");
            }
            int mediana = MeanOfMeans(medianas);
            System.out.println("\nMediana de las medianas: " + mediana);
            seguir = false;
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

    public static void BubbleSort(int[] array, int numero) {
        if (numero == 1) {
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int X = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = X;
                    }
                }
            }

            BubbleSort(array, numero - 1);
        }
    }

    public static void Ordenamiento(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int numero = matriz.length;
            BubbleSort(matriz[i], numero);
        }
    }

    public static ArrayList<Integer> ArrayMedians(int[][] matriz) {
        ArrayList<Integer> medians = new ArrayList<>();
        int median;
        for (int i = 0; i < matriz.length; i++) {
            int[] fila = new int[matriz[i].length];
            for (int j = 0; j < matriz[i].length; j++) {
                fila[j] = matriz[i][j];
            }
            BubbleSort(fila, matriz.length);
            int half = fila.length / 2;
            if (fila.length % 2 == 0) {
                median = (fila[half - 1] + fila[half]) / 2;
            } else {
                median = fila[half];
            }
            medians.add(median);
        }
        return medians;
    }

    public static void BubbleSortArrayList(ArrayList<Integer> medians) {
        int current_spot;
        int next_spot;
        for (int i = 0; i < medians.size() - 1; i++) {
            current_spot = medians.get(i);
            next_spot = medians.get(i + 1);
            if (current_spot > next_spot) {
                medians.set(i, next_spot);
                medians.set(i + 1, current_spot);
            }
        }
    }

    public static int MeanOfMeans(ArrayList<Integer> medians) {
        int first_half;
        int second_half;
        int mitad = (medians.size() - 1) / 2;
        if (medians.size() % 2 == 0) {
            first_half = medians.get(mitad - 1);
            second_half = medians.get(mitad);
            return (first_half + second_half) / 2;
        } else {
            return mitad;
        }
    }
}
