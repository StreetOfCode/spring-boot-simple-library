package sk.streetofcode.springbootsimplelibraryproject.api.request;

public class AddAuthorRequest {
    private String name;

    public AddAuthorRequest() {
    }

    ;

    public AddAuthorRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
