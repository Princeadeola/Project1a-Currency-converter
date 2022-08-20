import java.util.Scanner;

public class step3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What your amount to convert: ");
        double userAmount = input.nextDouble();

        System.out.println(convert(userAmount));
    }

    public static double convert(double userAmount){
        double conversionRate = 650; //using dollar first

        double converted = userAmount * conversionRate;

        return converted;
    }
}
//Building a console application
//Create my java project
//Create a variable to store a hard-coded currency rate and input
//Complete the app by implementing the whole conversion
//Enhance the class by creating a method to convert the currency
//Enhance the class to get the amount to be converted from the user
//Enhance the class to get the conversion rate from the user
//Enhance the class to get the conversion rate online
//Enhance the application to give users the option of online or manual conversion rate
//Make it more friendly and fun
//Push final code to GitHub