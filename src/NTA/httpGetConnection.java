package NTA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.fusesource.jansi.AnsiConsole;

/**
 * Class for establishing an HTTP GET connection and receiving data.
 *
 * This class provides a method, hConnect, to configure and send an HTTP GET
 * request.
 *
 * Usage: hConnect(url)
 *
 * Parameters: - url: The URL from which the GET request is sent.
 *
 * Note: - The method sends an HTTP GET request to the specified URL and prints
 * the response.
 *
 * @Author: Mauros Milach Junior (github.com/MaurosMJ)
 */
public class httpGetConnection {

    /**
     * Sends an HTTP GET request to the specified URL and prints the response.
     *
     * @param url The URL from which the GET request is sent.
     */
    private final String resetColor = "\u001B[0m";
    private final String redColor = "\u001B[91m";
    private final String greenColor = "\u001B[32m";
    
    public void hConnect(String url) {
        try {
            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response code and response
            System.out.println("Response code: " + responseCode);
            System.out.println("Response:");
            System.out.println(redColor+response.toString()+resetColor);

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            System.out.print(redColor);
            e.printStackTrace();
            System.out.print(resetColor);
        }
    }
}
