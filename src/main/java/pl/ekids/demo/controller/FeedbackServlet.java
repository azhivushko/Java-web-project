package pl.ekids.demo.controller;

import pl.ekids.demo.dao.DaoFactory;
import pl.ekids.demo.dao.FeedbackDao;
import pl.ekids.demo.model.Feedback;
import pl.ekids.demo.service.FeedbackService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private final FeedbackService service = new FeedbackService();
    private final FeedbackDao dao = DaoFactory.getDao(DaoFactory.DaoType.POSTGRES);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //?list=true -> showAll = true
        String showAll = request.getParameter("list");
        if ("true".equals(showAll)) {
            request.setAttribute("feedbackList", dao.findAll());
            request.getRequestDispatcher("/feedback-list.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ratingStr = request.getParameter("rating");
        String comment = request.getParameter("comment");
        boolean allowContact = request.getParameter("allowContact") != null;

        if (name == null || name.isBlank() || email == null || email.isBlank()
                || ratingStr == null || !ratingStr.matches("\\d+") || comment == null || comment.isBlank()) {
            request.setAttribute("error", "All fields are required and rating must be numeric.");
            request.getRequestDispatcher("/form.jsp").forward(request, response);
            return;
        }

        int rating = Integer.parseInt(ratingStr);
        if (rating < 1 || rating > 5) {
            request.setAttribute("error", "Rating must be between 1 and 5.");
            request.getRequestDispatcher("/form.jsp").forward(request, response);
            return;
        }

        // Create Feedback object
        Feedback feedback = new Feedback(name.trim(), email.trim(), rating, comment.trim(), allowContact);
        dao.save(feedback);

        // Format LocalDateTime for JSP display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm");
        String formattedDate = feedback.getSubmittedAt().format(formatter);
        request.setAttribute("formattedDate", formattedDate);

        // Process message
        String summary = service.createSummary(feedback);
        request.setAttribute("summary", summary);

        HttpSession session = request.getSession();
        session.setAttribute("lastFeedback", feedback);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
