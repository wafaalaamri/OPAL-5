import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FeedbackPortal {

    static Scanner scanner = new Scanner(System.in);
    
    static String[] names = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];

    static int feedbackCount = 0;

    public static void main(String[] args) {
        loadFeedback();
        int choiceNum = 0;

        while (choiceNum != 7) {
            showMenu();

            System.out.print("Choose: ");

    // Check if the input is an integer to prevent crashing on letters
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                scanner.next(); // Discard the invalid input
                continue; // Skip the rest and loop back to the menu
            }

            choiceNum = scanner.nextInt();
            scanner.nextLine(); 

            switch (choiceNum) {
                    case 1:
                        addFeedback();
                        break;
                    case 2:
                        showAll();
                        break;
                    case 3:
                        showAverage();
                        break;
                    case 4:
                        searchByRating();
                        break;
                    case 5:
                        deleteFeedback();
                        break;
                    case 6:
                        saveFeedback();
                    break;
                    case 7:
                        System.out.println("Thank you!");
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
        }        
        scanner.close();
    }

    static void showMenu() {
        System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add feedback");
        System.out.println("2. Show all feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
    }

    public static void addFeedback() {
        if (feedbackCount >= 100) {
            System.out.println("Error: Feedback list is full!");
            return;
        }

        try {
            System.out.print("Enter name: ");
            String nameInput = scanner.nextLine().trim();
            if (nameInput.isEmpty()) {
                System.out.println("Error: Name cannot be empty ");
                return;
            }

           int ratingInput = 0;
           while (true) {
                System.out.print("Enter rating (1 to 5): ");
                ratingInput = scanner.nextInt();
                scanner.nextLine(); 

                if (ratingInput >= 1 && ratingInput <= 5) {
                    break; 
                } else {
                    System.out.println("Error: Rating must be between 1 and 5. Please try again.");
                }
            }

            System.out.print("Enter comment: ");
            String commentInput = scanner.nextLine().trim();
            if (commentInput.isEmpty()) {
                System.out.println("Error: Comment cannot be empty.");
                return;
            }

            // Store in arrays 
            names[feedbackCount] = nameInput;
            ratings[feedbackCount] = ratingInput;
            comments[feedbackCount] = commentInput;
            feedbackCount++;

            System.out.println("Feedback added successfully!");

        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
           
        }
    }

    public static void showAll(){

        
        
        for (int i = 0; i < feedbackCount; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Rating: " + ratings[i]);
            System.out.println("Comment: " + comments[i]);
        
        }

        loadFeedback();
    }



    public static void showAverage(){
        if (feedbackCount == 0) {
        System.out.println("No feedback to show average.");
        return;
        }
        double sumAvg =0.0;
        double ratingAvg =0.0;
        for(int i=0; i<feedbackCount; i++){
            sumAvg += ratings[i];
            ratingAvg = sumAvg /feedbackCount ;  
        }
        System.out.println("the average of all ratings = " + ratingAvg);
      
    }
    
    public static void searchByRating(){

        if (feedbackCount == 0) {
        System.out.println("No feedback to search.");
        return;
        }
        System.out.println("enter number of rating to git feedback :");
        int numberRating = scanner.nextInt();
 
        for(int i=0 ; i<= feedbackCount; i++){
            
             if(ratings[i] == numberRating){
                System.out.println(" this all comment belong to "+ ratings[i] + "\n"+ comments[i]);
                break;
            }
        }
    }

    public static void deleteFeedback(){
        if (feedbackCount == 0) {
            System.out.println("No feedback available to delete.");
            return;
        }
    
        showAll();
        System.out.println("Enter number of which feedback you want to delete: ");
        int delFeedback = scanner.nextInt();

        int deleteIndex = delFeedback - 1;

   
        if (deleteIndex < 0 || deleteIndex >= feedbackCount) {
            System.out.println("Invalid feedback number");
            return;
        }

        for (int i = deleteIndex; i < feedbackCount - 1; i++) {
            names[i] = names[i + 1];
            ratings[i] = ratings[i + 1];
            comments[i] = comments[i + 1];
        }

        feedbackCount--;

        System.out.println("Feedback deleted successfully!");
    }


    public static void saveFeedback(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt",true))) {
            for (int i = 0; i < feedbackCount; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }
            writer.close();
            System.out.println("the feedbacks saved successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void loadFeedback(){
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                names[feedbackCount] = parts[0];
                ratings[feedbackCount] = Integer.parseInt(parts[1]);
                comments[feedbackCount] = parts[2];
                feedbackCount++;
            }
      
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    



}
    