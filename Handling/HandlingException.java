import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HandlingException {

    public static void main(String[] args) throws IOException{
       
        
        try {
            Read();
            
        } catch (IOException e) {
            System.err.println("A I/O error occurred: " + e);
            
        }
       
         WriterFile();

        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("\nthe file is copied successfully");

        }catch (FileNotFoundException e) {
            System.err.println("Error The text file could not be found." +e);

        }
        

    }

      // Read from a file
    private static void Read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        System.out.println(br.readLine());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
    
        }
        br.close();
    
    }


    // Write to a file
    private static void WriterFile() throws IOException {
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text to write to the file: ");
        String text = input.nextLine();
        writer.write("\n"+text);
        writer.close();
      
       
    }

    
    
}