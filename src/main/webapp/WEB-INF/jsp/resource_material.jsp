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
            <h1 class="page-header">资源素材管理</h1>
        </div>
    </div><!--/.row-->
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">资源素材管理</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body tabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab1" data-toggle="tab">图片</a></li>
                        <li><a href="#tab2" data-toggle="tab">音频</a></li>
                        <li><a href="#tab3" data-toggle="tab">视频</a></li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    新增图片
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="/file/uploadSingle" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>文件</label>
                                            <input type="file" name="filedata">
                                        </div>
                                        <input type = "hidden" name="type" value="img">
                                        <br>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab2">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    新增音频
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="/file/uploadSingle" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>文件</label>
                                            <input type="file" name="filedata">
                                        </div>
                                        <input type = "hidden" name="type" value="voice">
                                        <br>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab3">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    新增视频
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="/file/uploadSingle" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>文件</label>
                                            <input type="file" name="filedata">
                                        </div>
                                        <input type = "hidden" name="type" value="video">
                                        <br>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.panel-->
        </div><!--/.col-->
    </div>

</div>

</body>
</html>
