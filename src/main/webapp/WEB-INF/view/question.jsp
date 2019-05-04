<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Quiz</title>

    <!-- reference our style sheet -->

    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>


<form:form action="nextQuestion" modelAttribute="question" method="post">

    <div id="wrapper">
        <div id="header">
            <h2>Question ${viewNumberQuestion}</h2>
        </div>
    </div>
    <br>

    <br><br>
    ${question.question}
    <br><br>

    <table>
        <tr>
            <th>Answer</th>
            <th>Select</th>
        </tr>

        <c:forEach var="answer" items="${question.answers}">
            <tr>
                <td>${answer.answer}</td>
                <td><input type="radio" name="idAnswer" value="${answer.idAnswer}"></td>
            </tr>
        </c:forEach>

    </table>
    <br><br>

    <c:choose>
        <c:when test="${viewNumberQuestion != quantityAnswer}">
            <input type="submit" value="Next Question">
            <br />
        </c:when>
        <c:otherwise>
            <input type="submit" value="Finish">
            <br />
        </c:otherwise>
    </c:choose>

</form:form>

</body>

</html>









