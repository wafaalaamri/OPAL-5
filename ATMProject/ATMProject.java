import java.util.Scanner;

public class ATMProject {

    static Scanner scanner = new Scanner(System.in);

    static int pin = 1234;

    static double balance = 1000.00;
    static int depositCount = 0;
    static double depositAmount=0.0;
    static double depositTotal = 0.0;
    
    static int withdrawalCount = 0;
    static double withdrawalTotal = 0.0;
    static double withAmount;

    

    static String tire ;
    

    public static void main(String[] args) {
        boolean logeState = false;
        
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter the PIN: ");
            int userPin = scanner.nextInt();

            if (userPin == pin) {
                System.out.println("Welcome!");
                logeState = true;

               

                int choiceNum;
                do {
                    menu();
                    System.out.print("Please enter a number choice from 0 to 8: ");

                    if(scanner.hasNextInt()){
                    choiceNum = scanner.nextInt();
                    

                    switch (choiceNum) {
                        case 1:
                            checkBalance();
                            break;
                        case 2:
                            deposit();
                            break;
                        case 3:
                            withdraw();
                            break;
                        case 4:
                            accountTier();
                            break;
                        case 5:
                            savingsProjection();
                            break;
                        case 6:
                            receiptSummary();
                            break;
                        case 7:
                            changePin();
                            break;    
                        case 0:
                            System.out.println("thank you!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                }
                    }else{
                        System.out.println("Invalid input Please enter a valid number");
                        scanner.next();
                        choiceNum = -1;
            }

                } while (choiceNum != 0);
                
                break; 

            } else {
                int attemptsLeft = 3 - i;
                if (attemptsLeft > 0) {
                    System.out.println("Wrong PIN. Attempts left: " + attemptsLeft);
                    System.out.println("Try again : ");
                } else {
                    System.out.println("Card locked");
                }
            }
        }

        scanner.close();
    }

    static void menu() {
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account tier");
        System.out.println("5. Savings projection");
        System.out.println("6. Receipt summary");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
    }

    public static void checkBalance(){
        System.out.printf("the balance = "  +  balance);
    }

    public static void deposit(){
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
       
        
        if (depositAmount > 0 && depositAmount <= 5000) {
            
            balance= balance + depositAmount;
            depositCount++;
            depositTotal += depositAmount;

            

            System.out.printf("Deposit successful. Balance: "+ balance);
            System.out.println(" Total successful deposits made: " + depositCount);
        } else {
            System.out.println("error");
        }
    }

    public static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double withAmount = scanner.nextDouble();

        if (withAmount <= 500 && withAmount > 0 && withAmount % 10 == 0 && (withdrawalTotal + withAmount) <= 1000) {
            double fee = 2.00;
            double total = fee + withAmount;
            if (balance >= total) {
                System.out.printf("Fee :" +  fee + "\n");
                balance =balance- total;
                withdrawalCount++;
                withdrawalTotal += withAmount;
    
                System.out.printf("Withdrawal successful. Balance :"  +  balance + "\n");
            } else {
                System.out.println("Invalid Withdrawal ");
            }
        } else if (withAmount > 500 && withAmount <= 1000 && withAmount % 10 == 0 && (withdrawalTotal + withAmount) <= 1000) {
            double fee = 5.00;
            double total = fee + withAmount;
            if (balance >= total) {
                System.out.printf("Fee :"  + fee);
                balance= balance - total;
                withdrawalCount++;
                withdrawalTotal += withAmount;

                
                System.out.printf("Withdrawal successful. Balance : "  +  balance);
            } else {
                System.out.println("Invalid Withdrawal ");
            }
        } else {
            System.out.println("Invalid withdrawal amount must be greater than 0 and a multiple of 10 ");
        } 
    }

    public static void accountTier(){
        String tier;
         int yearlyInterest;

        if(balance < 1000){
            tier="Bronze";
            yearlyInterest=1;
        }else if (balance<5000){
            tier="Silver";
            yearlyInterest=2;

        }else if (balance < 20000){
            tier="Gold";
            yearlyInterest=3;

        }else{
            tier="Platinum";
            yearlyInterest=4;

        } 
        System.out.print("Tire : " + tier);
        System.out.print("  ,interest rate  = " + yearlyInterest+"%");
 
    }

   public static void savingsProjection(){
        System.out.print("Enter number of years (1 to 10)");
        int numYears= scanner.nextInt();
        double curentBlance;
        String tier;

        if (numYears <= 1 || numYears >= 10) {
        System.out.println("Please enter number between 1 and 10");
        return;
    
         }

        for(int i=1; i <= numYears ; i++){
            
            if (balance <1000){
                curentBlance= balance*0.01;
                balance=balance+curentBlance;
               
            } else if (balance <5000) {
                curentBlance= balance*0.02;
                balance=balance+curentBlance;
                
            } else if (balance <20000) {
                curentBlance= balance*0.03;
                balance=balance+curentBlance;
              
            } else {
                curentBlance= balance*0.04;
                balance=balance+curentBlance;
                
            }
            System.out.println("Year" + i +":" + balance);
        }
        
    }

    public static void receiptSummary(){
        
        System.out.println("Deposits: " + depositCount + " total: " + depositTotal);
        System.out.println("Withdrawals: " + withdrawalCount + " total: " + withdrawalTotal);
        System.out.println("Balance: " +balance);


    }

    public  static void changePin(){
        System.out.println("Enter old PIN");
        int oldPin = scanner.nextInt();

        if (oldPin != pin) {
            System.out.println("Incorrect PIN");

        }else{
            System.out.println("Enter new pin must be 4 digits): "); 
            int newPIN = scanner.nextInt();
        
            if (newPIN >= 1000 && newPIN <= 9999) {
                System.out.println("Confirm new PIN");
                int confNewPin = scanner.nextInt(); 
            
                if (newPIN == confNewPin) {
                    pin = newPIN;
                    System.out.println("PIN changed successfully!");
                } else {
                    System.out.println("PINs do not match.");
                }
       
            }else{
                System.out.println("Pin must be 4 digits");
            }
        
        
        }
    }
    


}