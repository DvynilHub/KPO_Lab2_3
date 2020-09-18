import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    // построчное считывание файла
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\123.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            int k = line.length()/2;
            int m[][] = new int[k][k];
            int h = 1;
            for (int i=0;i<k;i++){
                m[0][i] = Character.getNumericValue(line.charAt(h));
                h+=2;
            }
            System.out.println(m[0][0]);
            System.out.println("--------------");
            int l = 1;
            while (line != null) {


                // считываем остальные строки в цикле
                line = reader.readLine();
                int o = 1;
                for (int i=0;i<k;i++){
                    m[l][i] = Character.getNumericValue(line.charAt(o));
                    o+=2;
                }
                l++;
            }
            for (int i = 0;i<k;i++){
                for (int j = 0;j<k;j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
