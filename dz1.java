import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

public class dz1 {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 2, 6, 1, 8, 7, 9, 5, 3, 16, 15, 56 };
        File file = new File("log.txt");
        StringBuilder sb = new StringBuilder();

        name(arr, sb, file);
    }

    public static void name(int[] arr, StringBuilder sb, File file) {
        int temp = 0;
        for (int j = 0; j < arr.length - 1 - j; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    try {
                        FileWriter fw = new FileWriter(file, true);
                        fw.write(Arrays.toString(arr));
                        fw.write("\n");
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n");
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}