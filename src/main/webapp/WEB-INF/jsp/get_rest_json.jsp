<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>CMSDemo|页面管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/datepicker3.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap-table.css" rel="stylesheet">
    <link href="${ctx}/static/css/styles.css" rel="stylesheet">
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">页面管理</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">页面管理</li>
        </ol>
    </div><!--/.row-->

    <br>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    页面管理
                </div>
                <div class="panel-body">
                    <a href=""><button type="button" class="btn btn-primary">新增页面版本</button></a>
                    <table  id="pageTable" data-toggle="table" >
                        <thead>
                        <tr>
                            <%--data-field的值为pojo类的属性值，不是数据库字段--%>
                            <th data-field="temperature" >温度</th>
                            <th data-field="humidity">湿度</th>
                        </tr>
                        </thead>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/chart.min.js"></script>
<script src="${ctx}/static/js/chart-data.js"></script>
<script src="${ctx}/static/js/easypiechart.js"></script>
<script src="${ctx}/static/js/easypiechart-data.js"></script>
<script src="${ctx}/static/js/bootstrap-datepicker.js"></script>
<script src="${ctx}/static/js/bootstrap-table.js"></script>
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $('#pageTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $('#pageTable').bootstrapTable({
            method: "get",  //使用post请求到服务器获取数据
            url: "/sitewhere/measurements", //获取数据源的URL
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 10,  //每页显示的记录数
            pageNumber:1, //当前第几页
            pageList: [5, 10, 15, 20, 25],  //记录数可选列表
            search: false,  //是否启用查询
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType : "undefined",
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                    page: params.pageNumber,
                    pageSize: params.pageSize
                };
                return param;
            },
        });
    }

    $(document).ready(function () {
        //调用函数，初始化表格
        initTable();

        //当点击查询按钮的时候执行
        $("#search").bind("click", initTable);
    });
</script>
</body>
</html>
