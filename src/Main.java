import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        double[][] matrix = matr();
        trans(matrix);





    }
    private static void trans(double[][] a){  //метод транспонирования и вывода матрицы
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    double temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
            System.out.println();
            System.out.println("Транспонированная матрица"+"\n-------------------------");
            for (double[] doubles : a) {
                for (int j = 0; j < a.length; j++) {
                    System.out.printf("%8.2f",doubles[j]);
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Матрицу невозможно транспонировать");
        } catch (NullPointerException e){
            System.out.println("Неверный формат матрицы");
        }

    }
    private static double[][] matr() throws IOException { //функция считывания матрицы из файла
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\123.txt"));
        try {
            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            int matrixWidth = lines.get(0).split(" ").length;
            int matrixHeight = lines.size();
            if (matrixHeight != matrixWidth){
                return null;
            }

            double[][] matrix = new double[matrixHeight][matrixWidth];

            for (int i = 0; i < matrixHeight; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    String[] line = lines.get(i).split(" ");
                    matrix[i][j] = Double.parseDouble(line[j]);
                }
            }
            System.out.println("Исходная матрица"+"\n-------------------------");
            for (int i = 0; i < matrixHeight; i++) {
                for (int j = 0;j<matrixWidth;j++){
                    System.out.printf("%8.2f",matrix[i][j]);
                }
                System.out.println();

            }
            return matrix;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e){
            System.out.println("Неверный формат элементов массива...");
            return null;
        }


    }

    }
