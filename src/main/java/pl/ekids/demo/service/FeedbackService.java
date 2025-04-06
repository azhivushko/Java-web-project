package pl.ekids.demo.service;

import pl.ekids.demo.model.Feedback;

public class FeedbackService {

    // Generates a personalized message based on rating
    public String createSummary(Feedback feedback) {
        String level = switch (feedback.getRating()) {
            case 5 -> "Excellent";
            case 4 -> "Good";
            case 3 -> "Average";
            case 2 -> "Needs Improvement";
            default -> "Poor";
        };

        return "Thank you, " + feedback.getName() +
                ", for your feedback! You rated us as '" + level +
                "'. Contact permission: " + (feedback.isAllowContact() ? "Yes" : "No") + ".";
    }
}
