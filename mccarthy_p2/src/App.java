import java.util.ArrayList;
import java.util.Scanner;

public class App {
    double bmiTotal = 0;

    private static boolean moreInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter more input? Y/N: ");

        String truthCheck = scan.next();

        boolean truthValue = false;

        if(truthCheck.equals("Y")) {
            truthValue = true;
        } else if(truthCheck.equals("N")) {
            truthValue = false;
        }

        return truthValue;
    }

    private static double getUserHeight() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a height (in inches): ");

        double height = scan.nextDouble();
        scan.nextLine();

        while(height < 0) {
            System.out.println("Invalid input, re-enter height: ");

            height = scan.nextDouble();
            scan.nextLine();
        }

        return height;
    }

    private static double getUserWeight() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a weight (in pounds): ");

        double weight = scan.nextDouble();
        scan.nextLine();

        while(weight < 0) {
            System.out.println("Invalid input, re-enter weight: ");

            weight = scan.nextDouble();
            scan.nextLine();
        }

        return weight;
    }

    static void displayBmiInfo(BodyMassIndex bmi) {
        double bmiScore = bmi.calculateBmi();
        String bmiCategory = bmi.calculateBmiCategory();

        System.out.println("User's BMI: " + bmiScore + ", User is: " + bmiCategory);
    }

    static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double average = 0.0;
        for (int counter = 0 ; counter < bmiData.size(); counter ++){
            average += bmiData.get(counter).calculateBmi();
        }
        average /= bmiData.size(); // check to make sure that size gives the right value
        System.out.printf("Average: %.2f", average);
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
