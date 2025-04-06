<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Feedback Result</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
<div class="result-container">
    <h2>Thank You!</h2>
    <p>${summary}</p>
    <c:if test="${not empty sessionScope.lastFeedback}">
        <h3>Your Submitted Data:</h3>
        <ul>
            <li><strong>Name:</strong> ${sessionScope.lastFeedback.name}</li>
            <li><strong>Email:</strong> ${sessionScope.lastFeedback.email}</li>
            <li><strong>Rating:</strong> ${sessionScope.lastFeedback.rating}</li>
            <li><strong>Comment:</strong> ${sessionScope.lastFeedback.comment}</li>
            <li><strong>Contact Permission:</strong> <c:out value="${sessionScope.lastFeedback.allowContact}" /></li>
            <li><strong>Submitted At:</strong> ${formattedDate}</li>
        </ul>
    </c:if>
    <a href="feedback">Back to Form</a>
</div>
</body>
</html>