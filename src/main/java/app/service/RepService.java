package app.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import app.entitiy.Rep;

public class RepService {
    private List<Rep> reps;

    public RepService(List<Rep> reps) {
        this.reps = reps;
    }


    public Rep repById(String id) {
        for (Rep rep : reps) {
            if (Objects.equals(rep.getId(), Long.valueOf(id))) {
                return rep;
            }
        }
        return null;
    }

    public Rep createRep(Rep rep) {
        rep.setId(reps.stream().map(Rep::getId).max(Comparator.naturalOrder()).orElse(0L) + 1);
        reps.add(rep);
        return rep;
    }
}
