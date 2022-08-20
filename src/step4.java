import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;


public class step4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

//        System.out.print("What your amount to convert: ");
//        double userAmount = input.nextDouble();
//
//        System.out.print("From what currency (i.e USD): ");
//        String fromCurrency = input.next();
//
//        System.out.print("To what currency (i.e NGN): ");
//        String toCurrency = input.next();
//
//        convertOnline(userAmount, fromCurrency, toCurrency);

        convertOnline(500, "USD", "NGN");

    }

    public static void convertOnline(double amount, String from, String to) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount)
                .addHeader("apikey", "gwLFIvZGpUvlzzvNZcBqmaridym1aTtl").method("GET", null).build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());  //=> Print all output in json format
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