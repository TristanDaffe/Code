<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <title> Inscription </title>
</head>
<body>

    <p>Welcome on inscription page</p>

    <form:form id="form"
               method="POST"
               action="/firstSpring/inscription/send"
               modelAttribute="user">
        <form:label path="name">Name </form:label>
        <form:input path="name"/>
        <form:errors path="name"/>

        <br>
        <form:label path="age" >Age </form:label>
        <form:input path="age" type="integer"/>
        <form:errors path="age"/>s
        <br>

        <form:radiobutton path="male" value="true" label="Boy"/>
        <form:radiobutton path="male" value="false" label="Girl"/>
        <br>

        What's your preferred hobby ?
        <form:select path="hobby">
            <form:options items ="${hobbies}" itemValue="id" itemLabel="name" />
        </form:select>
        <br>

        <form:button>Send</form:button>
    </form:form>
</body>
</html>