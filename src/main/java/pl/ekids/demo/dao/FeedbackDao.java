package pl.ekids.demo.dao;

import pl.ekids.demo.model.Feedback;
import java.util.List;

public interface FeedbackDao {
    void save(Feedback feedback);
    List<Feedback> findAll();
}

