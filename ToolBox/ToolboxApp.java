
import java.util.Scanner;

public class ToolboxApp {

     static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args){

        
        int choiceNum;
        
      do {
            menu();

            System.out.println("Please enter a number choice from 0 to 10 :  ");

            if(scanner.hasNextInt()){

                choiceNum = scanner.nextInt();

                switch (choiceNum) {
                    case 1:
                        Fahrenheit();
                        break;
                    case 2:
                        evenOrOdd();
                        break;
                    case 3:
                        maxOfThree();
                        break;
                    case 4:
                        factorial();
                        break;
                    case 5:
                        multiplicationTable();
                        break;
                    case 6:
                        starTriangle();
                        break;
                    case 7:
                        isPrime();
                        break;
                    case 8:
                        reverseNumber();
                        break;
                    case 9:
                        numberPyramid();
                        break;
                    case 10:
                        starDiamond();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            }else{
                System.out.println("Invalid input Please enter a valid number");
                scanner.next();
                choiceNum = -1;
            }

        } while (choiceNum != 0);

        scanner.close();
    

     }

    static void menu() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or odd");
        System.out.println("3. Maximum of three numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication table");
        System.out.println("6. Triangle of stars");
        System.out.println("7. Prime check");
        System.out.println("8. Reverse a number");
        System.out.println("9. Number pyramid");
        System.out.println("10. Star diamond");
        System.out.println("0. Exit");
    }

    public static void Fahrenheit() {
        System.out.println("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = celsius * 9.0 / 5.0 + 32;

        System.out.println("Fahrenheit: " + fahrenheit);
    }

    public static void evenOrOdd() {
         System.out.println("Enter a number: ");
        int number =scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
    }

    public static void maxOfThree(){
        System.out.println("Enter a number 1: ");
        int num1 =scanner.nextInt();

        System.out.println("Enter a number 2: ");
         int num2 =scanner.nextInt();

        System.out.println("Enter a number 3: ");
        int num3 =scanner.nextInt();

        if(num1 > num2 && num1 > num3 ){
            System.out.println(num1 + " is largest");
        }else if(num2 > num1 && num2 > num3){
            System.out.println(num2 + " is largest");

        }else if(num3 > num1 && num3 > num2){
            System.out.println(num3 + " is largest");

        }else{
            System.out.println("numbers equals");

        }

    }

    public static void factorial(){
        System.out.println("Enter a number factorial: ");
        int fact =scanner.nextInt();

        if (fact < 0 || fact > 15) {
            System.out.println("Enter a non-negative number (0 to 15)");
            return;
        }
        long x = 1;
        for (int i = 1; i <= fact; i++) {
            x = x * i;
        }
         System.out.println(fact + "! = " + x);
        }


        public static void multiplicationTable(){
            System.out.print("Enter a number Multiplication Table: ");
            int multiTable = scanner.nextInt();
            

            for (int i = 1; i <= 10; i++){
                int result= multiTable * i;
                System.out.println(multiTable + " x " + i + " = " + result);
            }
        }

        public static void starTriangle(){
            System.out.print("Enter a number of rows to shap by star: ");
            int sizeTriangle = scanner.nextInt();

            for(int i=0; i<=sizeTriangle; i++){

                for (int st = 1; st <= (2 * i - 1); st++) {
                    System.out.print("* ");
        
                }
                System.out.println();
            }
        }

        public static void isPrime(){
            System.out.print("Enter a number greater than 1: ");
            int numPrime = scanner.nextInt();

            boolean isPrimeNum = true;

            for (int i = 2; i < numPrime; i++) {
        
                if (numPrime % i == 0) {
                isPrimeNum = false;
                break; 
                }
            }
    
            if (isPrimeNum) {
                System.out.println(numPrime + " is a prime number.");
            }else {
                System.out.println(numPrime + " is not a prime number.");
            }
        }


        public static void reverseNumber(){
            System.out.print("Enter a number to revers: ");
            int numRevers = scanner.nextInt();

            int reversed = 0;
    
            while (numRevers > 0) {
                int lastDigit = numRevers % 10;           
                reversed = (reversed * 10) + lastDigit;
                numRevers = numRevers / 10;                     
    }
    
            System.out.println("Reversed number: " + reversed);


        }


        public static void numberPyramid(){
            System.out.print("Enter a number of rows: ");
            int sizePyramid = scanner.nextInt();

            for(int i=1; i<=sizePyramid; i++){

                for (int num = 1; num <= i; num++) {
                    System.out.print(num + " ");
        
                }
                System.out.println();
            }
        }

        public static void starDiamond(){
            System.out.print("Enter a number of rows for diamond shape: ");
            int sizeDiamond = scanner.nextInt();

            for (int i = 1; i <= sizeDiamond; i++) {

            
                for (int sp = sizeDiamond; sp > i; sp--) {
                    System.out.print(" ");
                }

            
                for (int star = 1; star <= (2 * i - 1); star++) {
                    System.out.print("*");
                }

            
            System.out.println();
            }   

        
            for (int i = sizeDiamond; i >= 1; i--) {

            
                for (int sp = sizeDiamond; sp > i; sp--) {
                    System.out.print(" ");
                }

        
                for (int star = 1; star <= (2 * i - 1); star++) {
                    System.out.print("*");
                }

            System.out.println();
            }

        }









}
    






