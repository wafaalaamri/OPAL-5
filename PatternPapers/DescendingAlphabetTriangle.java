import java.util.Scanner;

public class DescendingAlphabetTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Rows: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
             
                char ch = (char) ('A' + (n - 1 - j));
                System.out.print(ch);
            }
            System.out.println();
        }

        scanner.close();
    }
}