<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="include/commonfile.jsp"/>
</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">CMSDemo</div>
            <div class="panel-body">
                <form role="form" action="user/login" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="请输入用户名" name="name" type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="" name="password" type="password" value="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="请输入验证码" name="codevalidate" type="text">
                        </div>
                        <div class="form-group">
                            <img id="codevalidate" src="/code/<%=new Date().getTime()%>" onclick="changeUrl()">
                            <button type="submit" class="btn btn-primary pull-right">登录</button>
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->

<script>
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
<script>
    function changeUrl() {
        var url = $("#codevalidate").prop('src');
        url = url.substr(0,url.lastIndexOf('/')+1);
        url = url + (new Date()).valueOf();
        $("#codevalidate").prop('src',url);
    }
</script>
</body>

</html>
