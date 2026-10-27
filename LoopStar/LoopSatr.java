public class LoopSatr {
    public static void main(String[] args) {
        int n = 7; // Total number of rows for the diamond (must be an odd number)
        int mid = n / 2;

        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            // Inner loop for columns
            for (int j = 0; j < n; j++) {
                
                // Use if statements to decide whether to print a star or a space
                if (i <= mid) {
                    // Upper half of the diamond (including the middle row)
                    if (j >= (mid - i) && j <= (mid + i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    // Lower half of the diamond
                    if (j >= (i - mid) && j <= (n - 1 - (i - mid))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            // Move to the next line after each row is complete
            System.out.println();
        }
    }
}   
