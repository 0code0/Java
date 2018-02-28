



<div class="navbar-container ace-save-state" id="navbar-container">
    <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
        <span class="sr-only">Toggle sidebar</span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>
    </button>

    <div class="navbar-header pull-left">
        <a href="<%=request.getContextPath()%>/DeshBoard.jsp" class="navbar-brand">
            <small>

                PIMDS 
            </small>
        </a>
    </div>

            
            
    <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">


            <li class="light-blue dropdown-modal">
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <img class="nav-user-photo" src="${Image}" alt="Jason's Photo" />
                    <span class="user-info">
                        <small>Welcome,</small>
                        ${UserName}

                    </span>

                    <i class="ace-icon fa fa-caret-down"></i>
                </a>

                <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                    <li>
                        <a href="<%=request.getContextPath()%>/Profile.jsp">
                            <i class="ace-icon fa fa-user"></i>
                            Profile
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/MyProject.jsp">
                            <i class="ace-icon fa fa-product-hunt"></i>
                            My Project
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/MyUploads.jsp">
                            <i class="ace-icon fa fa-upload"></i>
                            My Upload
                        </a>
                    </li>

                    <li class="divider"></li>

                    <li>
                        <a href="/PIMDSWEB/Logout">
                            <i class="ace-icon fa fa-power-off"></i>
                            Logout
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <% HttpSession httpsession = request.getSession();
        if (httpsession.getAttribute("Role").equals("admin")) {%>
    <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
            <li class=" dropdown-modal">
                <a href="<%=request.getContextPath()%>/Admin/AdminDefault.jsp" >
                    <span class="user-info">
                        <small>Admin</small>
                    </span>
                </a>
            </li>
        </ul>
    </div>

    <%}%>

<div class="navbar-brand pull-right">
    <small style="color: #ffe7b4">
                    ${Email}
                </small>
            </div>

</div><!-- /.navbar-container -->