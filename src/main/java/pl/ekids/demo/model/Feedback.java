package pl.ekids.demo.model;

import java.time.LocalDateTime;

// A simple POJO to store feedback data
public class Feedback {
    private String name;
    private String email;
    private int rating;
    private String comment;
    private boolean allowContact;
    private LocalDateTime submittedAt;

    public Feedback(String name, String email, int rating, String comment, boolean allowContact) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.comment = comment;
        this.allowContact = allowContact;
        this.submittedAt = LocalDateTime.now();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public boolean isAllowContact() { return allowContact; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
}
