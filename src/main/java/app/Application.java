package app;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;

import java.util.List;
import java.util.Objects;

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
        path("/api", () -> {
            path("/reps", () -> {
                get("", (request, response) -> reps, gson::toJson);
                get("/:id", (request, response) -> repById(request.params("id")), gson::toJson);
            });
            path("/states", () -> {
                get("", (request, response) -> states, gson::toJson);
                get("/:id", (request, response) -> stateById(request.params("id")), gson::toJson);
            });
            path("/zips", () -> {
                get("", (request, response) -> zips, gson::toJson);
                get("/:id", (request, response) -> zipById(request.params("id")), gson::toJson);
            });
        });
    }

    private static Zip zipById(String id) {
        for (Zip zip : zips) {
            if (Objects.equals(zip.getId(), Long.valueOf(id))) {
                return zip;
            }
        }
        return null;
    }

    private static State stateById(String id) {
        for (State state : states) {
            if (Objects.equals(state.getId(), Long.valueOf(id))) {
                return state;
            }
        }
        return null;
    }

    private static Rep repById(String id) {
        for (Rep rep : reps) {
            if (Objects.equals(rep.getId(), Long.valueOf(id))) {
                return rep;
            }
        }
        return null;
    }

    private static void initializeDb() {
        states = ImmutableList.of(new State(1L, "Texas", "TX"));
        zips = ImmutableList.of(new Zip(1L, "12345", states.get(0)));
        reps = ImmutableList.of(new Rep(1L, "Rep1", zips, states));
    }
}
