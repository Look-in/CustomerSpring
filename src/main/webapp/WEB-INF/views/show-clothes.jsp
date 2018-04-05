<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shankunassv
  Date: 28.02.2018
  Time: 22:01
  Страница ввода/изменения Clothes.
--%>
<head>
    <link href="<c:url value="resources/global.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="resources/item.css"/>" rel="stylesheet" type="text/css"/>
    <title>${param.type} ${param.action}</title>
</head>
<%@include file="includes/header.jsp" %>
<form:form method="POST" name="Modify" action="/modify-clothes" modelAttribute="item" id="item">
    <input type="hidden" name="action" value="${ param.action }">
    <form:input type="hidden" path="itemType.itemTypeId"/>
    <form:input type="hidden" path="itemType.type"/>
    <form:input type="hidden" path="itemId"/>
    <table class="table-edit">
        <tr>
            <td>Type</td>
            <td><form: path="name"/></td>
        </tr>
        <tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
            </td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Status</form:label></td>
            <td>
                <form:select path="itemStatus.itemStatusId">
                    <c:forEach var="istatus" items="${statuses}">
                        <option ${istatus.itemStatusId == item.itemStatus.itemStatusId ? 'selected="true"' : ''} value="${istatus.itemStatusId}">${istatus.status}</option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
<tr>
    <td><form:label path="season">Season</form:label></td>
    <td><form:input path="season"/></td>
</tr>
</table>
<input type="submit" name="button" value="Submit"/>
<a href="/" title="">Cancel</a>
</form:form>
</body>
</html>
