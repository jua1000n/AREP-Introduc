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
    /**
     * El metodo main obtiene los valores que se mandan desde el frontend y los retorna en formato JSON
     * @param args
     */
    public static void main(String[] args)
    {
        Convert convert = new Convert();
        port(getPort());

        path("convert", () ->{
            get("/celsiusF", (req, res) -> {
                res.type("application/json");
                String value = req.queryParams("value");
                if(value == null) {
                    return error();
                } else {
                    try{
                        return convert.fahrenheitCelsiusJson(Double.parseDouble(value));
                    }catch (NumberFormatException e) {
                        return error();
                    }
                }
            });

            get("/fahrenheitC", (req, res) -> {
                res.type("application/json");
                String value = req.queryParams("value");
                System.out.println(value);
                if(value == null) {

                    return error();
                } else {
                    try{
                        return convert.celsiusFahrenheitJson(Double.parseDouble(value));
                    }catch (NumberFormatException e) {
                        return error();
                    }
                }
            });
        });

        path("", () ->{

        });
    }

    /**
     * Manda el error de que los parametros no son correctos en formnato JSON
     * @return retorna un objeto de tipo JSON
     */
    private static JsonObject error() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", "Error 406: Not acceptable");
        return jsonObject;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }
}
