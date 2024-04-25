package sk.streetofcode.springbootsimplelibraryproject.api.request;

public class AddBookRequest {

    private Long authorId;
    private String title;
    private String description;

    public AddBookRequest() {
    }

    ;

    public AddBookRequest(Long authorId, String title, String description) {
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
