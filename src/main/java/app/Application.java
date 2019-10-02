package app;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;

import app.entitiy.Rep;
import app.entitiy.State;
import app.entitiy.Zip;

public class Application {
    private static List<Rep> reps;
    private static List<State> states;
    private static List<Zip> zips;

    public static void main(String[] args) {
        initializeDb();
        Gson gson = new Gson();
        port(4567);
        get("/", (request, response) -> "Go away");
        get("/reps", (request, response) -> reps, gson::toJson);
        get("/states", (request, response) -> states, gson::toJson);
        get("/zips", (request, response) -> zips, gson::toJson);
    }

    private static void initializeDb() {
        states = ImmutableList.of(new State(1L, "Texas", "TX"));
        zips = ImmutableList.of(new Zip(1L, "12345", states.get(0)));
        reps = ImmutableList.of(new Rep(1L, "Rep1", zips, states));
    }
}
