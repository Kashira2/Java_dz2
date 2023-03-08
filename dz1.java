import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

public class dz1 {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 2, 7, 1, 8, 3, 6, 5 };

        StringBuilder sb = new StringBuilder();

        name(arr, sb);
    }

    public static void name(int[] arr, StringBuilder sb) {
        int temp = 0;
        for (int j = 0; j < arr.length - 1 - j; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sb.append(Arrays.toString(arr));
                    try {
                        FileWriter fw = new FileWriter("log.txt", false);
                        fw.write(sb.toString());
                        
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }
}