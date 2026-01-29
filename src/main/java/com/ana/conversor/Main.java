package com.ana.conversor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    static void main() {

        IO.println("Conversor de Monedas iniciando...");

        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/0be846e107e79638c06c34fd/latest/USD");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(content.toString(), JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

        while (continuar) {
            IO.println("*** Conversor de Monedas ***");
            IO.println("Ingrese la cantidad de dinero en USD: ");
            double cantidad = scanner.nextDouble();

            IO.println("Por favor ingrese el código de moneda (Ej: EUR, ARS, BLR): ");
            String moneda = scanner.next().toUpperCase();

            if (rates.has(moneda)) {
                double tasa = rates.get(moneda).getAsDouble();
                IO.println(cantidad + " USD = " + (cantidad * tasa) + " " + moneda);
            } else {
                IO.println("Moneda no encontrada en la API. ¡Vuelva a intentar de nuevo!");
            }

            IO.println("¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.next().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }

        }

        IO.println("Gracias por usar el Conversor de Monedas. ¡Hasta luego!");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

