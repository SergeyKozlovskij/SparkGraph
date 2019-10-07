package app.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import app.entitiy.State;

public class StateService {
    private List<State> states;

    public StateService(List<State> states) {
        this.states = states;
    }

    public State stateById(String id) {
        for (State state : states) {
            if (Objects.equals(state.getId(), Long.valueOf(id))) {
                return state;
            }
        }
        return null;
    }

    public State createState(State state) {
        state.setId(states.stream().map(State::getId).max(Comparator.naturalOrder()).orElse(0L) + 1);
        states.add(state);
        return state;
    }
}
