<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>All Feedback</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
<div class="result-container">
    <h2>All Feedback</h2>
    <c:if test="${empty feedbackList}">
        <p>No feedback yet.</p>
    </c:if>
    <c:if test="${not empty feedbackList}">
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Rating</th>
                <th>Comment</th>
                <th>Allow Contact</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${feedbackList}">
                <tr>
                    <td>${f.name}</td>
                    <td>${f.email}</td>
                    <td>${f.rating}</td>
                    <td>${f.comment}</td>
                    <td><c:out value="${f.allowContact}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <br/>
    <a href="feedback">← Back to form</a>
</div>
</body>
</html>