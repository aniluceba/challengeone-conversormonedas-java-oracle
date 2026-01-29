package com.ana.conversor;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

//public class ConversorApp {
//    public static void main() {
//        String jsonResponse = "{ \"amount\":1, \"base\":\"USD\", \"date\":\"2026-01-29\", \"rates\":{\"EUR\":0.92,\"ARS\":880.0,\"BRL\":5.10}}";

//        Gson gson = new Gson(); JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

//        JsonObject rates = jsonObject.getAsJsonObject("rates");
//        double eurRate = rates.get("EUR").getAsDouble();
//        double arsRate = rates.get("ARS").getAsDouble();
//        double brlRate = rates.get("BRL").getAsDouble();

//        System.out.println("1 USD = " + eurRate + " EUR");
//        System.out.println("1 USD = " + arsRate + " ARS");
//        System.out.println("1 USD = " + brlRate + " BRL");



//    }
//}