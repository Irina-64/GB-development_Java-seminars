// пример реализации алгоритма сортировки пузырьком числового массива с записью промежуточных результатов в лог-файл

import java.io.FileWriter;
import java.io.IOException;

public class BubbleSortWithLogging {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 1, 6};
        bubbleSortWithLogging(array, "log.txt");
        printArray(array);
    }

    public static void bubbleSortWithLogging(int[] array, String logFileName) {
        try (FileWriter writer = new FileWriter(logFileName)) {
            int n = array.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        // Swap elements
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                // Write intermediate result to log file
                writer.write("Iteration " + (i + 1) + ": ");
                printArrayToFile(array, writer);
                if (!swapped) {
                    break; // Array is already sorted, terminate the loop early
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArrayToFile(int[] array, FileWriter writer) throws IOException {
        for (int i = 0; i < array.length; i++) {
            writer.write(array[i] + " ");
        }
        writer.write("\n");
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
