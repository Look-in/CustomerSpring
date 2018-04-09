<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.02.2018
  Time: 0:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link href="<c:url value="../resources/global.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="../resources/item.css"/>" rel="stylesheet" type="text/css"/>
    <title>${param.type}</title>
</head>
<body>
<%@include file="includes/header.jsp" %>
<div>
    <div class="sort-item">
        <div class="add-item">
            <form name="selecting" method="get">
                <input type="hidden" name="itemTypeId" value="${ param.itemTypeId }">
                <select name="sortingBy">
                    <option value="" selected>Sort by</option>
                    <c:forEach var="sort" items="${sortBy}">
                        <option value="${sort}" ${param.sortingBy == sort ? 'selected="selected"' : ''}>${sort.displayName}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Sort"/>
            </form>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="add-item">
                <c:set var="addTypeURL" value="${(param.type == 'clothes' ) or (param.type == 'bicycles' )
                        ? param.type
                        : 'item'}"/>
                <c:url var="addurl" value="modify-${addTypeURL}">
                    <c:param name="action" value="ADD"/>
                    <c:param name="itemTypeId" value="${ param.itemTypeId }"/>
                    <c:param name="type" value="${ param.type }"/>
                </c:url>
                <a ${ empty param.itemTypeId ? 'hidden="true"' : '' } href="${addurl}">Add item</a>
            </div>
        </sec:authorize>
    </div>
    <div>
        ${ param.requestKey=="" ? "" : param.requestKey }
    </div>
    <div>
        <c:url var="view" value="view-items">
            <c:param name="sortingBy" value="${param.sortingBy}"/>
        </c:url>
        <a href="${view}" title="">ALL</a>
        <c:forEach var="itemType" items="${itemTypes}">
            <c:url var="view" value="view-items">
                <c:param name="itemTypeId" value="${itemType.itemTypeId}"/>
                <c:param name="type" value="${itemType.type}"/>
                <c:param name="sortingBy" value="${param.sortingBy}"/>
            </c:url>
            <a class="item-type" href="${view}" title="">${itemType.type}</a>
        </c:forEach>
    </div>
    <div class="parent-item">
        <c:forEach var="elem" items="${item}" varStatus="status">
            <div class="img-responsive">
                <img class="item-image" src="/resources/images/no-img.png">
                <span class="range-txt position-rage-bottom">
                     <c:out value="${ elem.itemStatus.status }"/><br>
                     <c:out value="${ elem.name }"/><br>
                     <strong><c:out value="${ elem.price }"/>$</strong>
            </span>
                    <%-- Only for role ADMIN available edit form --%>
                <sec:authorize access="hasRole('ADMIN')">
                    <c:set var="type" value="${(elem.itemType.type== 'clothes' ) or (elem.itemType.type== 'bicycles' )
                        ? elem.itemType.type
                        : 'item'}"/>
                    <div class="item edit">
                        <c:url var="editurl" value="modify-${type}">
                            <c:param name="itemId" value="${elem.itemId}"/>
                            <c:param name="type" value="${elem.itemType.type}"/>
                            <c:param name="itemTypeId" value="${ param.itemTypeId }"/>
                        </c:url>
                        <a href="${editurl}">Edit</a>
                    </div>
                    <div class="item delete">
                        <form:form method="DELETE" name="Modify"
                                   action="/delete">
                            <input type="hidden" name="itemTypeId" value="${ param.itemTypeId }">
                            <input type="hidden" name="type" value="${ param.type }">
                            <input type="hidden" name="itemId" value="${elem.itemId}">
                            <input class="btn-delete" type="submit" value="Delete"/>
                        </form:form>
                    </div>
                </sec:authorize>
                    <%-- Only for role USER available adding items to basket --%>
                <sec:authorize access="hasRole('USER')">
                    <c:set var="type" value="${(elem.itemType.type== 'clothes' ) or (elem.itemType.type== 'bicycles' )
                        ? elem.itemType.type
                        : 'item'}"/>
                    <div class="item edit">
                        <c:url var="viewurl" value="/shopping-cart/show-${type}">
                            <c:param name="itemId" value="${elem.itemId}"/>
                        </c:url>
                        <a href="${viewurl}">Show</a>
                    </div>
                    <div class="item delete">
                        <form:form method="POST" name="shopping-cart" action="/shopping-cart">
                            <input type="hidden" name="itemId" value="${elem.itemId}">
                            <input class="btn-delete" type="submit" value="Add cart"/>
                        </form:form>
                    </div>
                </sec:authorize>
            </div>
        </c:forEach>
    </div>
</div>
<div ${action == "shopping" ? '' : 'hidden="true"' }>
    <form:form method="POST" name="addItemCart" action="/shopping-cart/put">
        <input class="btn-delete" type="submit" value="putOrder"/>
    </form:form>
</div>
</body>
</html>
