package pl.ekids.demo.model;

// A simple POJO to store feedback data
public class Feedback {
    private String name;
    private int rating;
    private String comment;
    private String date;

    public Feedback(String name, int rating, String comment, String date) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
        this.date = date;

    }

    // Getters only (no need to change data after creation)
    public String getName() { return name; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public String getDate() { return  date; }
}