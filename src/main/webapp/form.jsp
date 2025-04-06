<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Feedback Form</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
<div class="form-container">
    <h2>Feedback Form</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form method="post" action="feedback">
        <label>Name:</label>
        <input type="text" name="name" required /><br/>

        <label>Email:</label>
        <input type="email" name="email" required /><br/>

        <label>Rating (1-5):</label>
        <input type="number" name="rating" min="1" max="5" required /><br/>

        <label>Comment:</label>
        <textarea name="comment" rows="4" required></textarea><br/>

        <label><input type="checkbox" name="allowContact" /> I agree to be contacted</label><br/>

        <input type="submit" value="Submit" class="submit-btn" />
    </form>
</div>
</body>
</html>
