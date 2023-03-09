import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class dz2 {
    public static void main(String[] args) {
        File file = new File("file1.txt");
        StringBuilder sb = new StringBuilder();

        try {
            FileReader fr = new FileReader(file);
            char[] a = new char[(int) file.length()];
            fr.read(a);
            for (char c : a) {
                sb.append(c);
            }
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        change_words(sb);
    }

    public static void change_words(StringBuilder sb) {
        String res = sb.toString();
        res = res.replace('"', (char) (' ')).replace(",", "")
                .replace("  ", " ").replace("фамилия :", "Студент")
                .replace("оценка :", "получил").replace("предмет :", "по предмету")
                .replace("[ ", "").replace("]", "")
                .replace("", "").replace(" Ст", "Ст")
                .replace(" Ст", "Ст").replace("ка", "ка.");
        System.out.println(res);
    }

}
