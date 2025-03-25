<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Feedback Form</title></head>
<body>
<h2>Leave Your Feedback</h2>

<!-- Show validation error -->
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<!-- Feedback form -->
<form method="post" action="feedback">
    Name: <input type="text" name="name" /><br/><br/>
    Rating (1-5): <input type="number" name="rating" min="1" max="5" /><br/><br/>
    Comment:<br/>
    <textarea name="comment" rows="5" cols="40"></textarea><br/><br/>
    <input type="submit" value="Submit Feedback" />
    Date: <input type="text" name="date">
</form>
</body>
</html>