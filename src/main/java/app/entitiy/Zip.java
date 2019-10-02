package app.entitiy;

public class Zip {
    private Long id;
    private String code;
    private State state;

    public Zip(Long id, String code, State state) {
        this.id = id;
        this.code = code;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
