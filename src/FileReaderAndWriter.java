import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderAndWriter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the input file name:: ");
        String input_file = scan.next();
        System.out.print("Enter the output file name:: ");
        String output_file = scan.next();
        try{
            FileReader reader = new FileReader(input_file);
            FileWriter writer = new FileWriter(output_file, true);
            int character;
            while ((character = reader.read()) != -1) {
                writer.write((char) character);
            }
            reader.close();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
