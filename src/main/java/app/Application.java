package app;

import static spark.Spark.get;
import static spark.Spark.port;

public class Application {
    public static void main(String[] args) {
        port(4567);
        get("/", (request, response) -> "Hello Spark");
        get("/:url", (request, response) -> "Hello Spark with " + request.params(":url"));
    }
}
