package pl.ekids.demo.dao;

import pl.ekids.demo.model.Feedback;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostgresFeedbackDao implements FeedbackDao {
    private final Connection connection;

    public PostgresFeedbackDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Feedback feedback) {
        String sql = "INSERT INTO feedback (name, email, rating, comment, allow_contact, submitted_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, feedback.getName());
            stmt.setString(2, feedback.getEmail());
            stmt.setInt(3, feedback.getRating());
            stmt.setString(4, feedback.getComment());
            stmt.setBoolean(5, feedback.isAllowContact());
            stmt.setTimestamp(6, Timestamp.valueOf(feedback.getSubmittedAt()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save feedback to database", e);
        }
    }

    @Override
    public List<Feedback> findAll() {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Feedback feedback = new Feedback(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getBoolean("allow_contact")
                );
                list.add(feedback);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve feedback from database", e);
        }
        return list;
    }
}
