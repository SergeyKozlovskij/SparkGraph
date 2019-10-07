package app;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import app.entitiy.Rep;
import app.entitiy.State;
import app.entitiy.Zip;
import app.service.RepService;
import app.service.StateService;
import app.service.ZipService;

public class Application {
    private static List<Rep> reps;
    private static List<State> states;
    private static List<Zip> zips;

    public static void main(String[] args) {
        initializeDb();
        Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper();
        RepService repService = new RepService(reps);
        StateService stateService = new StateService(states);
        ZipService zipService = new ZipService(zips);

        port(4567);
        get("/", (request, response) -> "Go away");
        path("/api", () -> {
            path("/reps", () -> {
                get("", (request, response) -> reps, gson::toJson);
                get("/:id", (request, response) -> repService.repById(request.params("id")), gson::toJson);
                post("", (request, response) -> repService.createRep(mapper.readValue(request.body(), Rep.class)), gson::toJson);
            });
            path("/states", () -> {
                get("", (request, response) -> states, gson::toJson);
                get("/:id", (request, response) -> stateService.stateById(request.params("id")), gson::toJson);
                post("", (request, response) -> stateService.createState(mapper.readValue(request.body(), State.class)), gson::toJson);

            });
            path("/zips", () -> {
                get("", (request, response) -> zips, gson::toJson);
                get("/:id", (request, response) -> zipService.zipById(request.params("id")), gson::toJson);
                post("", (request, response) -> zipService.createZip(mapper.readValue(request.body(), Zip.class)), gson::toJson);
            });
        });
    }

    private static void initializeDb() {
        states = Lists.newArrayList(new State(1L, "Texas", "TX"));
        zips = Lists.newArrayList(new Zip(1L, "12345", states.get(0)));
        reps = Lists.newArrayList(new Rep(1L, "Rep1", zips, states));
    }
}
