
<%@page import="java.util.List"%>
<% List<BusinessObject.ProjectDocument> projectDocuments = BusinessLogic.ProjectDocumentBL.GetAllByProject(Integer.parseInt(request.getParameter("Id"))); 

if(projectDocuments.isEmpty()){%>
  
<tr>
    <td colspan="4" style="color: red;text-align: center;" >No data found</td>
</tr>
    
<%}else{

%>


<tbody>

    <%for (BusinessObject.ProjectDocument projectDocument : projectDocuments) {%>
    <tr>
        <td class="center">
            <div class="action-buttons">
                <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                    <i class="ace-icon fa fa-angle-double-down"></i>
                    <span class="sr-only">Details</span>
                </a>
            </div>
        </td>
        <td class="center">
            <a href="<%= projectDocument.getURL()%>" target="_blank"><%= projectDocument.getName()%></a>
        </td>
        <td class="center" ><% BusinessObject.DocumentCategory docCategory = BusinessLogic.DocumentCategoryBL.GetSingle(projectDocument.getDocumentCategoryId());%>
            <%= docCategory.getName()%>
        </td>
        <td class="center" ><%= projectDocument.getVersion()%></td>

    </tr>

    <tr class="detail-row">
        <td colspan="8">
            <div class="table-detail">
                <div class="row">

                    <div class="col-xs-12 col-sm-7">
                        <div class="space visible-xs"></div>

                        <div class="profile-user-info profile-user-info-striped">
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Title</div>

                                <div class="profile-info-value">
                                    <span><%= projectDocument.getTitle()%> </span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Name </div>

                                <div class="profile-info-value">
                                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                                    <span><%= projectDocument.getName()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Document Category </div>

                                <div class="profile-info-value">
                                    <span><%= docCategory.getName()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Description </div>

                                <div class="profile-info-value">
                                    <span><%= projectDocument.getDescription()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Version </div>

                                <div class="profile-info-value">
                                    <span><%= projectDocument.getVersion()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Source </div>

                                <div class="profile-info-value">
                                    <span><%= projectDocument.getSource()%></span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Author </div>

                                <div class="profile-info-value">
                                    <span><%= projectDocument.getAuthor()%></span>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
            <div class="space-10"></div>
            <div id="accordion" class="accordion-style2">
                <div class="group">

                    <div>
                        <div class="col-sm-6">
                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <div class="dialogs">

                                        <% List<BusinessObject.Comment> Comments = BusinessLogic.CommentBL.GetAllByProjectDocumentAndParentId(projectDocument.getId());

                                            for (BusinessObject.Comment comment : Comments) {

                                                BusinessObject.User CommentUser = BusinessLogic.UserBL.GetSingle(comment.getUserId());
                                        %>       


                                        <div class="itemdiv ">
                                            <div class="user">
                                                <img alt="<%= CommentUser.getUserName()%>" src="<%= CommentUser.getUrl()%>" />
                                            </div>

                                            <div class="body">
                                                <div class="time">
                                                    <i class="ace-icon fa fa-clock-o"></i>
                                                    <span class="green"><%= comment.getBase().getCreatedOn()%></span>
                                                </div>

                                                <div class="name">
                                                    <a target="_blank" href="<%= request.getContextPath()%>/ProfileById.jsp?Id=<%= CommentUser.getId()%>"><%= CommentUser.getName()%></a>

                                                    <% HttpSession httpsession = request.getSession();

                                                        if (httpsession.getAttribute("UserName").equals(CommentUser.getUserName())) {%>
                                                    <button class="btn btn-round btn-danger btn-sm" id="<%= comment.getId()%>" onclick="UserCommentDelete(this.id)">
                                                        <i class="ace-icon fa fa-trash-o bigger-110"></i>

                                                    </button>           
                                                    <%} else {%>
                                                    <button class="btn disabled btn-round btn-sm">
                                                        <i class="ace-icon fa fa-trash-o bigger-110"></i>

                                                    </button>           


                                                    <%}%>

                                                </div>
                                                <div class="text"><%= comment.getComment()%></div>

                                                <div class="tools">
                                                    <div class="input-group">
                                                        <input placeholder="Type your message here ..." type="text" id="<%= projectDocument.getId()%>aa"  class="form-control" />
                                                        <input type="hidden" value="<%= comment.getId()%>" id="hiddencommentId" />
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-sm btn-info no-radius" id="<%= projectDocument.getId()%>" onclick="SubComment(this.id)" type="button">
                                                                <i class="ace-icon fa fa-share"></i>
                                                                Comment
                                                            </button>
                                                        </span>
                                                    </div>
                                                </div>

                                            </div>

                                        </div>



                                        <% List<BusinessObject.Comment> SubComments = BusinessLogic.CommentBL.GetAllByParentId(comment.getId());

                                            for (BusinessObject.Comment SubComment : SubComments) {

                                                BusinessObject.User SubCommentUser = BusinessLogic.UserBL.GetSingle(SubComment.getUserId());%>
                                        <div class="space-10"></div>
                                        <div class="itemdiv " style="margin-left: 50px;">
                                            <div class="user">
                                                <img alt="<%= SubCommentUser.getName()%>" src="<%= SubCommentUser.getUrl()%>" />
                                            </div>

                                            <div class="body">
                                                <div class="time">
                                                    <i class="ace-icon fa fa-clock-o"></i>
                                                    <span class="blue"> <%= SubComment.getBase().getCreatedOn()%> </span>
                                                </div>

                                                <div class="name">
                                                    <a target="_blank" href="<%= request.getContextPath()%>/ProfileById.jsp?Id=<%= SubCommentUser.getId()%>"><%= SubCommentUser.getName()%></a>
                                                </div>
                                                <div class="text">
                                                    <%= SubComment.getComment()%>
                                                    <% if (httpsession.getAttribute("UserName").equals(SubCommentUser.getUserName())) {%>
                                                    <button class="btn btn-round btn-danger btn-sm" id="<%= comment.getId()%>" onclick="UserCommentDelete(this.id)">
                                                        <i class="ace-icon fa fa-trash-o bigger-110"></i>

                                                    </button>           
                                                    <%} else {%>
                                                    <button class="btn disabled btn-round btn-sm">
                                                        <i class="ace-icon fa fa-trash-o bigger-110"></i>

                                                    </button>           


                                                    <%}%>
                                                </div>


                                            </div>



                                        </div>
                                        <div class="space-10"></div>
                                        <%

                                            }

                                        %>




                                        <%}%>

                                    </div>

                                    <div class="form-actions">
                                        <div class="input-group">
                                            <input placeholder="Type your message " type="text" id="<%= projectDocument.getId()%>a" class="form-control" name="Comment" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-sm btn-info no-radius" id="<%= projectDocument.getId()%>" onclick="UserComment(this.id)" name="DocumentId" type="button">
                                                    <i class="ace-icon fa fa-share"></i>
                                                    Comment
                                                </button>
                                            </span>
                                        </div>
                                    </div>

                                </div><!-- /.widget-main -->

                                <%}%>
                            </div><!-- /.widget-body -->
                        </div><!-- /.widget-box -->

                    </div><!-- /.col -->

                </div>
            </div>
        </td>
    </tr>


</tbody>

<%}%>