package edu.escuelaing.arep;

import com.google.gson.JsonObject;
import edu.escuelaing.arep.services.Convert;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Convert convert = new Convert();
        port(getPort());

        path("convert", () ->{
            get("/celsiusF", (req, res) -> {
                res.type("application/json");
                String value = req.queryParams("value");
                if(value == null) {
                    return "Error 406: Not acceptable";
                } else {
                    try{
                        return convert.fahrenheitCelsiusJson(Double.parseDouble(value));
                    }catch (NumberFormatException e) {
                        return "Error 406: Not acceptable";
                    }
                }
            });

            get("/fahrenheitC", (req, res) -> {
                res.type("application/json");
                String value = req.queryParams("value");
                System.out.println(value);
                if(value == null) {

                    return "Error 406: Not acceptable";
                } else {
                    try{
                        return convert.celsiusFahrenheitJson(Double.parseDouble(value));
                    }catch (NumberFormatException e) {
                        return "Error 406: Not acceptable";
                    }
                }
            });
        });

        path("", () ->{

        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }
}
