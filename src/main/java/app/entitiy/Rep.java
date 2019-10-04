package app.entitiy;

import java.util.List;

public class Rep {
    private Long id;
    private String name;
    private List<Zip> zipCodes;
    private List<State> states;

    public Rep() {
    }

    public Rep(Long id, String name, List<Zip> zipCodes, List<State> states) {
        this.id = id;
        this.name = name;
        this.zipCodes = zipCodes;
        this.states = states;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zip> getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(List<Zip> zipCodes) {
        this.zipCodes = zipCodes;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
