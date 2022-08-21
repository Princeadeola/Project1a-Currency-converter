package FinishedProject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    private static Scanner input;

    public void getUserInput() throws IOException {
        input = new Scanner(System.in);

        System.out.println("Welcome to an online currency converter console");
        System.out.println("How would you like to do your currency conversion");
        System.out.println("1. Online (Automatically)");
        System.out.println("2. Offline (Manually)");
        System.out.print("Select an option 1|2|0 (0 to exit): ");
        int userOption = input.nextInt();

        CurrencyConverter.options(userOption);
    }

    public static void options(int option) throws IOException {
        if (option == 1){
            System.out.println("This is an online currency converter, ensure your data is on");
            System.out.print("What your amount to convert: ");
            double userAmount = input.nextDouble();

            System.out.print("From what currency (i.e USD): ");
            String fromCurrency = input.next();

            System.out.print("To what currency (i.e NGN): ");
            String toCurrency = input.next();

            convertOnline(userAmount, fromCurrency, toCurrency);
            //convertOnline(500,"USD","NGN");

        } else if (option == 2) {
            System.out.println("Welcome to the offline currency converter");
            System.out.println("i.e 650NGN = 1USD so Currency rate = 650");
            System.out.print("What your amount to convert(foreign currency): ");
            double userAmount = input.nextDouble();

            System.out.print("Currency rate (local currency for 1 foreign currency): ");
            double fromCurrency = input.nextDouble();

            convert(userAmount, fromCurrency);
        }else if (option == 0){
            System.out.println("Exiting application, Thank you");

        }else {
            System.out.println("Wrong input");
        }
    }

    public static void convertOnline(double amount, String from, String to) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount)
                .addHeader("apikey", "gwLFIvZGpUvlzzvNZcBqmaridym1aTtl").method("GET", null).build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());  //=> Print all output in json format
    }

    public static void convert(double userAmount, double fromRate){

        double myCurrency = (userAmount * fromRate);

        System.out.println(myCurrency);
    }
}
