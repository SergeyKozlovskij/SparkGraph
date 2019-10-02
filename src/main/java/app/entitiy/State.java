package app.entitiy;

public class State {
    private Long id;
    private String name;
    private String abbrev;

    public State(Long id, String name, String abbrev) {
        this.id = id;
        this.name = name;
        this.abbrev = abbrev;
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

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
}
