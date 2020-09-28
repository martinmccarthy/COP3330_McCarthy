import static java.lang.Math.pow;

public class BodyMassIndex {
    private double height;
    private double weight;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBmi() {
        return (703 * weight) / pow(height, 2);
    }

    public String calculateBmiCategory() {
        String bmiCategory;
        double bmi = calculateBmi();

        if(bmi < 18.5) {
            bmiCategory = "Underweight";
        }
        else if(bmi >= 18.5 && bmi < 25) {
            bmiCategory = "Normal weight";
        }
        else if(bmi >= 25 && bmi < 30) {
            bmiCategory = "Overweight";
        }
        else {
            bmiCategory = "Obesity";
        }

        return bmiCategory;
    }
}
