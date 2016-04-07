/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

/**
 *
 * @author Arnoldas
 */
public class Sort {
    public static int operationCount = 0;
    
    public static void bubbleSort(int array[])
    {
        for (int i =0; i < array.length-1; i++) {
            opPlus();
            for (int j = i+1; j < array.length; j++) {
                {
                    opPlus();
                    if ( array[i] > array[j])
                    {
                        opPlus();
                        int temporary = array[i];
                        opPlus();
                        array[i] = array[j];
                        opPlus();
                        array[j] = temporary;
                        opPlus();
                    }
                }
            }
        }
    }
    private static void opPlus(){
        operationCount++;
    }
    public static void main(String[] args) {
        int []arr={10,5, 9, 10, 10, 10, 21, 5, 15,
            15, 15, 1, 515, 151, 51, 51, 51, 1, 51, 
            515, 15, 4, 8, 4, 1, 8, 3, 18, 31};
        long startTime = System.nanoTime();

        bubbleSort(arr);
        long endTime = System.nanoTime();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("That took " + (endTime - startTime) + " nanoseconds");
    }
}
