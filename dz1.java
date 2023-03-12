import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.*;
// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

public class dz1 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] { 4, 2, 6, 1, 8, 7, 9, 5, 3, 16, 15, 56 };
        // File file = new File("log.txt");
        StringBuilder sb = new StringBuilder();

        name(arr, sb);
    }

    public static void name(int[] arr, StringBuilder sb) throws IOException {
        int temp = 0;

        Logger ll = Logger.getLogger(dz1.class.getName());
        String logsPath = "log.txt";
        FileHandler fh = new FileHandler(logsPath, false);
        ll.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        // XMLFormatter form = new XMLFormatter();
        fh.setFormatter(formatter);

        for (int j = 0; j < arr.length - 1 - j; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    ll.log(Level.INFO, Arrays.toString(arr));
                }
            }
        }
    }
}