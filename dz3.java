// дополнительно. К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class dz3 {
    public static void main(String[] args) throws IOException{
        Logger ll = Logger.getLogger(dz3.class.getName());
        String logsPath = "logcalc.txt";
        FileHandler fh = new FileHandler(logsPath, true);
        ll.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        // XMLFormatter form = new XMLFormatter();
        fh.setFormatter(formatter);

        
        Scanner reader = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        double num1 = reader.nextDouble();
        
        System.out.println("Введите знак (+ - / *): ");
        char sign = reader.next().charAt(0);

        System.out.printf("Введите второе число: ");
        double num2 = reader.nextDouble();

        reader.close();

        double res = 0;
        
        if (sign == '+') res = num1 + num2;
        else if (sign == '-') res = num1 - num2;
        else if (sign == '*') res = num1 * num2;
        else if (sign == '/') res = num1 / num2;

        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        sb.append(num1 + " " + sign + " " + num2 + " = " + res);
        ll.log(Level.INFO, sb.toString());
    }
}