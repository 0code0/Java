
<%@page import="BusinessLogic.DocumentBL"%>
<%@page import="java.util.List"%>
<ul class="nav nav-list" style="margin-left: 300px;">
    <% List<BusinessObject.Document> Document1s = BusinessLogic.DocumentBL.GetAllnull();
        for (BusinessObject.Document document1 : Document1s) {%>

    <li class="hover">
        <a href="#">
            <span class="menu-text"> <%= document1.getName()%> </span>
        </a>

        <ul class="submenu">

            <% List<BusinessObject.Document> Document2s = BusinessLogic.DocumentBL.GetAllByParentId(document1.getId());

                for (BusinessObject.Document document2 : Document2s) {%>

            <li class="active open hover">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-caret-right"></i>

                    <%= document2.getName()%>

                    <% List<BusinessObject.Document> Document3s = BusinessLogic.DocumentBL.GetAllByParentId(document2.getId());
                        if (Document3s.size() > 0) {

                            out.println("<b class='arrow fa fa-angle-right'></b>");
                        }
                    %>

                </a>



                <ul class="submenu" >
                    <% for (BusinessObject.Document document3 : Document3s) {%>

                    <li class="active open hover">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-caret-right"></i>

                            <%= document3.getName()%>
                            <% List<BusinessObject.Document> Document4s = BusinessLogic.DocumentBL.GetAllByParentId(document3.getId());
                                if (Document4s.size() > 0) {

                                    out.println("<b class='arrow fa fa-angle-right'></b>");
                                }
                            %>


                        </a>



                        <ul class="submenu">
                            <% for (BusinessObject.Document document4 : Document4s) {%>
                            <li class="active open hover">
                                <a href="#" class="dropdown-toggle">
                                    <i class="menu-icon fa fa-caret-right"></i>

                                    <%= document4.getName()%>
                                    <% List<BusinessObject.Document> Document5s = BusinessLogic.DocumentBL.GetAllByParentId(document4.getId());

                                        if (Document5s.size() > 0) {

                                            out.println("<b class='arrow fa fa-angle-right'></b>");
                                        }
                                    %>


                                </a>
                                <ul class="submenu">
                                    <% for (BusinessObject.Document document5 : Document5s) {%>

                                    <li class="active open hover">
                                        <a href="#" class="dropdown-toggle">
                                            <i class="menu-icon fa fa-caret-right"></i>

                                            <%= document5.getName()%>
                                        </a>
                                    </li>   

                                    <% } %>
                                </ul>
                            </li>
                            <%}  %>
                        </ul>
                    </li>
                    <%} %>
                </ul>

            </li>

            <%}%>
        </ul>

    </li>

    <%}%>
</ul><!-- /.nav-list -->
