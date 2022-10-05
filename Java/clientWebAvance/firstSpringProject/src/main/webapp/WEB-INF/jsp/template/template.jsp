<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>
<head>
  <link type="text/css" href="<spring:url value='/css/first.css' />" rel="stylesheet">
  <title>
    ${titrePage}
  </title>
</head>
<body>
  <div>
    <!-- Top banner -->
    Banner
  </div>

  <div>
    <!-- Main content -->
    <tiles:insertAttribute name="main-content"/>
    <br>
    <img src='<spring:url value="/images/banane.jpg"/>' />
  </div>

  <div>
    <!-- Footer -->
    footer
  </div>
</body>
</html>
