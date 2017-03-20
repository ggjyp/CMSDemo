<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li class="active"><a href="${ctx}/index"><span class="glyphicon glyphicon-dashboard"></span> 首页</a></li>
        <li><a href="${ctx}/page_manager"><span class="glyphicon glyphicon-th"></span> 页面管理</a></li>
        <li class="parent ">
            <a href="#">
                <span class="glyphicon glyphicon-list"></span> 资源管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="${ctx}/file/material">
                        <span class="glyphicon glyphicon-share-alt"></span> 资源素材管理
                    </a>
                </li>
                <li>
                    <a class="" href="${ctx}/file/index">
                        <span class="glyphicon glyphicon-share-alt"></span> 资源文件管理
                    </a>
                </li>
            </ul>
        </li>
        <li role="presentation" class="divider"></li>
    </ul>
</div><!--/.sidebar-->