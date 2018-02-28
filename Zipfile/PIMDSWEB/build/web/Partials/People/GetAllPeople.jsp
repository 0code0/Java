
<%@page import="java.util.List"%>
<%List<BusinessObject.User> users = BusinessLogic.UserBL.GetAll();%>

<tbody>

    <%for (BusinessObject.User user : users) {%>
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
            <%= user.getName()%>
        </td>
        <td class="center" >
            <%= user.getExtn()%>
        </td>
        <td class="center" ><%= user.getSeatNo()%></td>

        <td class="center" >
            <%BusinessObject.EmployeeType emptype = BusinessLogic.EmployeeTypeBL.GetSingle(user.getEmployeeId());

                out.println(emptype.getName());
            %>


        </td>

        <td class="center" ><image src="<%= user.getUrl()%>" height='50' width='50' alt="<%= user.getName()%>'Photo'" /></td>
    </tr>

    <tr class="detail-row">
        <td colspan="8">
            <div class="table-detail">
                <div class="row">

                    <div class="col-xs-12 col-sm-2">
                        <div class="text-center">
                            <img height="150" class="thumbnail inline no-margin-bottom" alt="<%= user.getName()%>'Photo'" src="<%= user.getUrl()%>" />

                            <br />
                            <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                <div class="inline position-relative">
                                    <a class="user-title-label" href="#">

                                        <i class="ace-icon fa fa-circle light-green"></i>
                                        &nbsp;
                                        <span class="white"><%= user.getName()%></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-7">
                        <div class="space visible-xs"></div>

                        <div class="profile-user-info profile-user-info-striped">
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Name</div>

                                <div class="profile-info-value">
                                    <span><%= user.getName()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Seat No </div>

                                <div class="profile-info-value">
                                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                                    <span><%= user.getSeatNo()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Extn </div>

                                <div class="profile-info-value">
                                    <span><%= user.getExtn()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Residence Address </div>

                                <div class="profile-info-value">
                                    <span><%= user.getAddress()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Mobile No </div>

                                <div class="profile-info-value">
                                    <span><%= user.getMobileNo()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name"> Celebrated DOB </div>

                                <div class="profile-info-value">
                                    <span><%= user.getCelebratedDateOfBirth()%></span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Official DOB </div>

                                <div class="profile-info-value">
                                    <span><%= user.getDateOfBirth()%></span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Date_of_Joining </div>

                                <div class="profile-info-value">
                                    <span><%= user.getDateofJoining()%></span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Emp Type </div>

                                <div class="profile-info-value">
                                    <span><%= emptype.getName()%></span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name"> Emergency No </div>

                                <div class="profile-info-value">
                                    <span><%= user.getEmergencyNo()%></span>
                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>

        </td>
    </tr>

    <%}%>

</tbody>