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
            <h1 class="page-header">资源文件管理</h1>
        </div>
    </div><!--/.row-->
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">资源文件管理</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    资源文件管理
                </div>
                <div class="panel-body">
                    <table>
                        <thead>
                        <tr>
                            <th>
                                目录名
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <a href="${ctx}/file/index">根目录</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href=${ctx}/file/index?path=${preParent}>上一级</a>
                            </td>
                        </tr>
                        <c:forEach items="${menus}" var="i" >
                            <tr>
                                <td>
                                    <a href="${ctx}/file/index?path=${i.lastDir}">${i.menuName}</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>


                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel-default">
            <div class="panel-heading">新增目录</div>
            <div class="panel-body">
                <form id="f" role="form" action="/file/addDir" method="post">
                    <div class="form-group">
                        <label for="menuName">目录名</label>
                        <input name="menuName" id="menuName" class="form-control">
                        <input name="dir" id="dir" type="hidden">
                        <input name="lastDir" id="lastDir" type="hidden">
                        <input name="parent" id="parent" type="hidden">
                    </div>
                    <div class="form-group">
                        <button type="button" onclick="save()">新增</button>
                    </div>
                    <script>
                        function save(){
                            var dir = "${dir}" + "/" + $("#menuName").val();
                            var lastDir = "/" + $("#menuName").val();
                            var parent = "${preParent}";
                            $("#dir").val(dir);
                            $("#lastDir").val(lastDir);
                            $("#parent").val(parent);
                            $("#f").submit();
                        }
                    </script>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
