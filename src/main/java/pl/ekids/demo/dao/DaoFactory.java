package pl.ekids.demo.dao;

import pl.ekids.demo.database.ConnectionFactory;

import java.sql.Connection;

public class DaoFactory {
    private DaoFactory() {
    }

    public enum DaoType {
        IN_MEMORY,
        POSTGRES
    }

    public static FeedbackDao getDao(DaoType type) {
        return switch (type) {
            case IN_MEMORY -> new InMemoryFeedbackDao();
            case POSTGRES -> {
                try {
                    Connection conn = ConnectionFactory.createConnection();
                    yield new PostgresFeedbackDao(conn);
                } catch (Exception e) {
                    throw new RuntimeException("Could not create PostgresFeedbackDao", e);
                }
            }
        };
    }
}
