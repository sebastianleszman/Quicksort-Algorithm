package app;

import java.util.Arrays;


/**
 * Algorytm Quicksort z pivotem wybieranym zawsze po środku.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3,-1,6,5,-2};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array){
        if (array == null || array.length == 0){ //sprawdzam czy array nie jest 0-rowy lub nullowy
            return;
        }
        int highIndex = array.length - 1;
        quickSort(array, 0, highIndex);
    }

    static void quickSort(int[] array, int lowIndex, int highIndex){ //metoda jest void
        if (lowIndex >= highIndex){ //sprawdzenie czy mam tylko jeden element w arrayu
            return;

        }else {
            int index = partition(array, lowIndex, highIndex); //ustawia liczby w relacji do pivota
            quickSort(array, lowIndex, index-1);
            quickSort(array, index+1, highIndex);
        }
    }

    static int getPivot(int[] array, int lowIndex, int highIndex){
        return array[lowIndex + (highIndex - lowIndex) / 2];
    }

    static int partition(int[] array, int lowIndex, int highIndex){
        int pivot = getPivot(array, lowIndex, highIndex);
        while (lowIndex < highIndex){ //sprawdzenie czy indexy przeskoczyly przez siebie
            while (array[lowIndex] < pivot){
                lowIndex++;
            }
            while (array[highIndex] > pivot){
                highIndex--;
            }
            if (array[lowIndex] > array[highIndex]){
                swap(array, lowIndex, highIndex);
            }
        }
        return lowIndex;
    }

    static void swap(int[] array, int lowIndex, int highIndex){
        int temp = array[lowIndex];
        array[lowIndex] = array[highIndex];
        array[highIndex] = temp;
    }
}
