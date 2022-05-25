import java.io.*;
import java.util.Scanner;

class Calculator {
    static double a = 0;
    static double b = 0;
    static String expression = null;

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");

        // Input from file
        try(FileReader fr = new FileReader("input.txt"))  {
            Scanner sc = new Scanner(fr);
            expression = sc.nextLine();
            sc.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Output in file
        try {
            fw.write(String.valueOf(calculate(expression)));
            fw.close();
        } catch (IllegalArgumentException e) {
            fw.write(e.getMessage());
            fw.close();
        }
    }

    public static double calculate(String s) {
            try {
                a = Double.parseDouble(s.split(" ")[0]);
                b = Double.parseDouble(s.split(" ")[2]);
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Error! Not number");
            }

                switch (s.split(" ")[1]) {
                    case "+":
                        return add(a,b);
                    case "-":
                        return sub(a,b);
                    case "*":
                        return mul(a,b);
                    case  "/":
                        if (b != 0) {
                            return div(a, b);
                        } else {
                            throw new IllegalArgumentException("Error! Division by zero");
                        }
                    default:
                        throw new IllegalArgumentException("Operation Error!");
                }

    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double sub(double x, double y) {
        return x - y;
    }

    public static double mul(double x, double y) {
        return x * y;
    }

    public static double div(double x, double y) {
            return x / y;
    }
}
