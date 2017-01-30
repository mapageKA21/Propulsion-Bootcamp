import java.text.DecimalFormat;
import java.util.Scanner;

public class BmiCalculator {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		System.out.println("Let's calculate your BMI (kg/m^2)");
		System.out.println("What is your weight in kilograms?");
		Scanner scanner = new Scanner(System.in);
		double weight = scanner.nextDouble();
		System.out.println("What is your height in meters?");
		double height = scanner.nextDouble();
		double bmi = (weight/height*height);
		DecimalFormat df = new DecimalFormat("#.##");
		bmi = Double.valueOf(df.format(bmi));
		System.out.println("Your BMI is: " + bmi);
		
	}

}
