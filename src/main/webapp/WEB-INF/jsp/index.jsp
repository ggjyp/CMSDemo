<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>CMSDemo|首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Home</h1>
        </div>
    </div><!--/.row-->
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">Home</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <%--<div class="panel-heading">--%>
                    <%--Default Panel--%>
                <%--</div>--%>
                <div class="panel-body">
                    这是首页
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
