import java.util.Scanner;

public class PlusSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an odd number of Rows: ");
        int n = scanner.nextInt();

        int mid = (n / 2) + 1; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
              
                if (i == mid || j == mid) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}