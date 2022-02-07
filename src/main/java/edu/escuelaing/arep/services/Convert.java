package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;

public class Convert {

    public Convert() {
    }

    /**
     * Convierte de grados celcius a grados fahrenheit
     * @param centigrados un numero en grados celcius
     * @return devulve un numero en grados fahrenheit
     */
    public double celsiusFahrenheit(double centigrados) {
        double fahrenheit = (centigrados*((double) 9/5))+32;
        return fahrenheit;
    }

    public JsonObject celsiusFahrenheitJson(double centigrados) {
        centigrados = celsiusFahrenheit(centigrados);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", centigrados);
        return jsonObject;
    }

    /**
     *Convierte de grados fahrenheit a grados celcius
     * @param fahrenheit un numero en grados fahrenheit
     * @return devulve un numero en grados celcius
     */
    public double fahrenheitCelsius(double fahrenheit) {
        double centigrados = (fahrenheit-32)*((double)5/9);
        return centigrados;
    }

    public JsonObject fahrenheitCelsiusJson(double fahrenheit) {
        fahrenheit = fahrenheitCelsius(fahrenheit);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", fahrenheit);
        return jsonObject;
    }
}
