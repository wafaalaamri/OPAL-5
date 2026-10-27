import java.util.Scanner;

public class ArraysTask {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        int[] numbers = {12, 7, 25, 3, 18, 9, 30, 14};

         
        System.out.println("Sum: "+sumArray(numbers));
        System.out.println("Average: "+averageArray(numbers));
        System.out.println("Max: "+findMax(numbers));
        System.out.println("Min: "+findMin(numbers));
        System.out.println("Difference: "+(findMax(numbers)-findMin(numbers)));
        System.out.println("Even numbers: "+countEven(numbers));


        System.out.println("Enter a number to search for");
        int target = scanner.nextInt(); 
        int index = indexOf(numbers, target);
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }
        

        System.out.print("Original : ");
        for (int i =0 ; i<numbers.length ; i++){
            System.out.print(numbers[i]+" ");
        }

        int[] reversed = reverseArray(numbers);

        System.out.print("\nReversed : ");
        for (int i =0 ; i<numbers.length ; i++){
            System.out.print(reversed[i]+" ");
        }

        int numStudents = 5;
        int[] grades = readGrades(numStudents);
    
        int passed = countPassed(grades);
        int failed = grades.length - passed;
    
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);


        scanner.close();

    }



    static int sumArray (int [] arr){
        int sum = 0;
        for (int i = 0; i<arr.length ; i++){
            sum+=arr[i];
        }
     return sum;
     
    }

    static double averageArray (int [] arr){
        double sum = 0; 
        for (int i = 0; i<arr.length ; i++){
            sum+=arr[i];
        }
     return sum/arr.length; 
    }

    static int findMax (int [] arr){
        int max = arr[0]; // assume the first element is the maximum
        for (int i = 1; i<arr.length ; i++){
            if (arr[i]>max){// compare each element with the current maximum
                max=arr[i];// update max if a larger element is found
            }
        }
     return max;
    }

    static int findMin(int [] arr){
        int min = arr[0]; 
        for (int i = 1; i<arr.length ; i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
     return min;
    }

    static int countEven(int [] arr){
        int countNumEven = 0;
        for (int i = 0; i<arr.length ; i++){
            if (arr[i]%2==0){
                countNumEven++;
            }
        }
     return countNumEven;
    }

    static int indexOf(int[]arr, int target){

        int valueNotFound = -1; 
        for (int i = 0; i<arr.length ; i++){
            if (arr[i]==target){
                return i; //index
            }
        }
        return valueNotFound; 
    }
     
    static int[] reverseArray(int[] arr) {
        int[] reverArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverArray[i] = arr[arr.length - 1 - i];
    }
        return reverArray;
    }

    static int[] readGrades(int size) {
        
        int[] grades = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("\nEnter grade " + (i + 1));
            grades[i] = scanner.nextInt();
        }
        return grades;
    }

    static int countPassed(int[] grades) {
        int passCount = 0;
        for (int grade : grades) {
            if (grade >= 50) {
                passCount++;
            }
        }
        return passCount;
    }


}