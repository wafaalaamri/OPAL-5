import java.util.Scanner;

public class OddNumberTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Rows: ");
        int n = scanner.nextInt();

        int currentOdd = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(currentOdd + " ");
                currentOdd += 2; 
            }
            System.out.println();
        }

        scanner.close();
    }
}