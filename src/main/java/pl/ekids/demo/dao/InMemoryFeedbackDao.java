package pl.ekids.demo.dao;

import pl.ekids.demo.model.Feedback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryFeedbackDao implements FeedbackDao {
    private final List<Feedback> feedbacks = new ArrayList<>();

    public InMemoryFeedbackDao() {
        feedbacks.add(new Feedback("Alice", "alice@example.com", 5, "Great job!", true));
        feedbacks.add(new Feedback("Bob", "bob@example.com", 4, "Nice interface.", false));
        feedbacks.add(new Feedback("Charlie", "charlie@example.com", 3, "Okay-ish", true));
        feedbacks.add(new Feedback("Dana", "dana@example.com", 2, "Could be better.", false));
        feedbacks.add(new Feedback("Eve", "eve@example.com", 1, "Not good.", true));
    }

    @Override
    public void save(Feedback feedback) {
        feedbacks.add(feedback);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbacks;
    }
}
