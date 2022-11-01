<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
    <spring:url var="localFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>

    <link type="text/css" rel="stylesheet" href="<spring:url value='/css/template.css' />">
    <title>
        ${titrePage}
    </title>
</head>
<body>
<div id="banner">
    <!-- Top banner -->
    <a href="${localFr}">
        <img alt="fr" src='<spring:url value="/images/localeFr.png"/>' />
    </a>
    <a href="${localEn}">
        <img alt="En" src='<spring:url value="/images/localeEn.png"/>' />
    </a>
    Banner
</div>

<div id="main-content">
    <!-- Main content -->
    <img src='<spring:url value="/images/banane.jpg"/>' />
    <tiles:insertAttribute name="main-content"/>
</div>
<div id="footer">
    <!-- Footer -->
    footer
</div>
</body>
</html>