<%-- 
    Document   : Menu
    Created on : Sep 23, 2016, 10:55:00 AM
    Author     : singhj1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <!-- Main menu -->
                    <li class="current"><a href="<%=request.getContextPath()%>/Admin/AdminDefault.jsp"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageProjectCategory.jsp"><i class="glyphicon glyphicon-list"></i> M Project Category</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageProjectClass.jsp"><i class="glyphicon glyphicon-list"></i> M Project Class </a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageProjectDetail.jsp"><i class="glyphicon glyphicon-list"></i> M Project Detail</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageProjectAllocation.jsp"><i class="glyphicon glyphicon-user"></i> M Group</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageDocumentCategory.jsp"><i class="glyphicon glyphicon-pencil"></i> M Document C</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageProjectDocument.jsp"><i class="glyphicon glyphicon-pencil"></i> M Project Doc</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageDocument.jsp"><i class="glyphicon glyphicon-pencil"></i> M Document</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageEmployeeType.jsp"><i class="glyphicon glyphicon-user"></i> M Employee C</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageUser.jsp"><i class="glyphicon glyphicon-user"></i> M User</a></li>
                    <li><a href="<%=request.getContextPath()%>/Admin/ManageComment.jsp"><i class="glyphicon glyphicon-comment"></i> M Comment</a></li>
                    <li><a href="<%=request.getContextPath()%>/DeshBoard.jsp"><i class="glyphicon glyphicon-comment"></i> Site Home</a></li>
                    
                    
                </ul>
             </div>
		  </div>