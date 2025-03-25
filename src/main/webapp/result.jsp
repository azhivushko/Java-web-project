<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Feedback Summary</title></head>
<body>
<h2>Thank you for your feedback!</h2>

<p><strong>Summary:</strong> <c:out value="${summary}" /></p>

<hr/>
<p><em>Session-stored feedback:</em></p>
<c:if test="${not empty sessionScope.lastFeedback}">
    <ul>
        <li>Name: ${sessionScope.lastFeedback.name}</li>
        <li>Rating: ${sessionScope.lastFeedback.rating}</li>
                  <li>Comment: ${sessionScope.lastFeedback.comment}</li>
        <li>Date: ${sessionScope.lastFeedback.date}</li>
    </ul>
</c:if>

<a href="feedback">Leave more feedback</a>
</body>
</html> 