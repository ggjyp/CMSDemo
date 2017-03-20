<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>CMSDemo|页面管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="include/commonfile.jsp"/>
    <script type="text/javascript" charset="utf-8" src="${ctx}/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/editor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/editor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">页面编辑</h1>
        </div>
    </div><!--/.row-->
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">页面编辑</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">页面编辑</div>
                <div class="panel-body">
                    <div class="col-md-6">
                        <form id="f" role="form" action="edit_result" method="post">
                            <div class="form-group">
                                <label for="versionId">版本号</label>
                                <input name="versionId" id="versionId" class="form-control" value="${page.versionId}">
                            </div>

                            <div class="form-group">
                                <label for="versionName">版本名称</label>
                                <input name="versionName" id="versionName" class="form-control" value="${page.versionName}">
                            </div>

                            <div class="form-group">
                                <label for="headCode">头部代码</label>
                                <textarea name="headCode" id="headCode" class="form-control" rows="3">${page.headCode}</textarea>
                            </div>

                            <div class="form-group">
                                <div class="controls">

                                    <script id="editor" type="text/plain"
                                            style="width:100%;height:500px;"></script>

                                    <script type="text/javascript">

                                        //实例化编辑器
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        var ue = UE.getEditor('editor');
                                        ue.ready(function() {
                                            ue.setContent("${page.bodyCode}");
                                        });
                                    </script>
                                    <%--<input name="versionId" id="h_version_id" type="hidden"/>--%>
                                    <%--<input name="versionName" id="h_version_name" type="hidden"/>--%>
                                    <%--<input name="headCode" id="h_head_code" type="hidden"/>--%>
                                    <input name="bodyCode" id="h_body_code" type="hidden"/>
                                </div>

                            </div>
                            <div class="control-group">
                                <button class="btn green"
                                        onclick="edit()"
                                        style="margin-left: 150px;"
                                        type="button"
                                >
                                    提交保存
                                </button>
                            </div>
                            <script>
                                function edit(){
                                    $("#h_body_code").val(ue.getContent());
                                    $("#f").submit();
                                }
                            </script>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
