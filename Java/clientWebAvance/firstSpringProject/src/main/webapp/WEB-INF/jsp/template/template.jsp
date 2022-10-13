<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="<spring:url value='/css/first.css' />">
  <title>
    ${titrePage}
  </title>
</head>
<body>
    <div id="banner">
      <!-- Top banner -->
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
