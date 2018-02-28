
<%@page import="java.util.List"%>
<%     List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAllByProjectCategory(Integer.parseInt(request.getParameter("Id")));
       

        for(BusinessObject.ProjectDetail projectDetail : projectDetails){ %>
<tr>
    <td class="center">
        <label class="pos-rel">
            <input type="checkbox" class="ace" />
            <span class="lbl"></span>
        </label>
    </td>

    <td class="center">
        <div class="action-buttons">
            <a href="#" class="green bigger-140 show-details-btn" title="Show Details">
                <i class="ace-icon fa fa-angle-double-down"></i>
                <span class="sr-only">Details</span>
            </a>
        </div>
    </td>

    <td>
        <a href="#">ace.com</a>
    </td>
    <td><%= projectDetail.getName() %></td>
    <td class="hidden-480"><% BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetail.getProjectClassId());
        
out.println(projectClass.getName());
        %></td>
    <td>
        <%BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(projectDetail.getProjectCategoryId());
        out.println(projectCategory.getName());
        %>
    </td>

    <td class="hidden-480">
        <span class="label label-sm label-warning">Expiring</span>
    </td>

    <td>
        <div class="hidden-sm hidden-xs btn-group">


            <button class="btn btn-xs btn-info" onclick="location.href = 'UpdateProject.jsp'">
                <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button class="btn btn-xs btn-danger">
                <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>


        </div>


    </td>
</tr>

<tr class="detail-row">
    <td colspan="8">
        <div class="table-detail">
            <div class="row">


                <div class="col-xs-12 col-sm-7">
                    <div class="space visible-xs"></div>

                    <div class="profile-user-info profile-user-info-striped">
                        <div class="profile-info-row">
                            <div class="profile-info-name"> Project Category </div>

                            <div class="profile-info-value">
                                <span>alexdoe</span>
                            </div>
                        </div>

                        <div class="profile-info-row">
                            <div class="profile-info-name"> Project Name </div>

                            <div class="profile-info-value">
                                <i class="fa fa-map-marker light-orange bigger-110"></i>
                                <span>Netherlands, Amsterdam</span>
                            </div>
                        </div>

                        <div class="profile-info-row">
                            <div class="profile-info-name"> IP Need </div>

                            <div class="profile-info-value">
                                <span>38</span>
                            </div>
                        </div>

                        <div class="profile-info-row">
                            <div class="profile-info-name"> Technology </div>

                            <div class="profile-info-value">
                                <span>2010/06/20</span>
                            </div>
                        </div>

                        <div class="profile-info-row">
                            <div class="profile-info-name"> Version </div>

                            <div class="profile-info-value">
                                <span>3 hours ago</span>
                            </div>
                        </div>

                        <div class="profile-info-row">
                            <div class="profile-info-name"> Product </div>

                            <div class="profile-info-value">
                                <span>Bio</span>
                            </div>
                        </div>
                        <div class="profile-info-row">
                            <div class="profile-info-name"> Division </div>

                            <div class="profile-info-value">
                                <span>Bio</span>
                            </div>
                        </div>
                        <div class="profile-info-row">
                            <div class="profile-info-name"> Class </div>

                            <div class="profile-info-value">
                                <span>Bio</span>
                            </div>
                        </div>
                        <div class="profile-info-row">
                            <div class="profile-info-name"> Sub Class </div>

                            <div class="profile-info-value">
                                <span>Bio</span>
                            </div>
                        </div>
                        <div class="profile-info-row">
                            <div class="profile-info-name"> Document Name </div>

                            <div class="profile-info-value">
                                <span>Bio</span>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

        <div id="accordion" class="accordion-style2">
            <div class="group">
                <h3 class="accordion-header">Document Name 1</h3>

                <div>
                    <div class="col-sm-6">



                        <div class="widget-body">
                            <div class="widget-main no-padding">
                                <div class="dialogs">
                                    <div class="itemdiv ">
                                        <div class="user">
                                            <img alt="Alexa's Avatar" src="<%=request.getContextPath()%>/Themes/public_html/assets/images/avatars/avatar1.png" />
                                        </div>

                                        <div class="body">
                                            <div class="time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span class="green">4 sec</span>
                                            </div>

                                            <div class="name">
                                                <a href="#">Alexa</a>
                                            </div>
                                            <div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque commodo massa sed ipsum porttitor facilisis.</div>

                                            <div class="tools">
                                                <div class="input-group">
                                                    <input placeholder="Type your message here ..." type="text" class="form-control" name="message" />
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-sm btn-info no-radius" type="button">
                                                            <i class="ace-icon fa fa-share"></i>
                                                            Comment
                                                        </button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="space-10"></div>
                                    <div class="itemdiv " style="margin-left: 50px;">
                                        <div class="user">
                                            <img alt="John's Avatar" src="<%=request.getContextPath()%>/Themes/public_html/assets/images/avatars/avatar.png" />
                                        </div>

                                        <div class="body">
                                            <div class="time">
                                                <i class="ace-icon fa fa-clock-o"></i>
                                                <span class="blue">38 sec</span>
                                            </div>

                                            <div class="name">
                                                <a href="#">Sub comment</a>
                                            </div>
                                            <div class="text">Raw denim you probably haven&#39;t heard of them jean shorts Austin.</div>


                                        </div>


                                        <div class="tools" style="margin-bottom: -10px;">


                                            <div class="input-group">
                                                <input placeholder="Type your message here ..." type="text" class="form-control" name="message" />
                                                <span class="input-group-btn">
                                                    <button class="btn btn-sm btn-info no-radius" type="button">
                                                        <i class="ace-icon fa fa-share"></i>
                                                        Comment
                                                    </button>
                                                </span>
                                            </div>

                                        </div>

                                    </div>

                                    <div class="space-10"></div>



                                </div>

                                <form>
                                    <div class="form-actions">
                                        <div class="input-group">
                                            <input placeholder="Type your message here ..." type="text" class="form-control" name="message" />
                                            <span class="input-group-btn">
                                                <button class="btn btn-sm btn-info no-radius" type="button">
                                                    <i class="ace-icon fa fa-share"></i>
                                                    Comment
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </form>
                            </div><!-- /.widget-main -->
                        </div><!-- /.widget-body -->
                    </div><!-- /.widget-box -->
                </div><!-- /.col -->

                <p>

                </p>
            </div>
        </div>



    </td>
</tr>
<%
}%>