<%@page import="java.util.List"%>
<!DOCTYPE HTML>

<html>
    <head>
        <title> INLATH </title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />


        <jsp:include page="Partials/Shared/CSSandJS.jsp" />

    </head>
    <body class="homepage">

        <!-- Header -->
        <jsp:include page="Partials/Shared/Menu.jsp" />
        <!-- Header -->

        <!-- Banner -->
        <div id="banner">
            <div class="container">
            </div>
        </div>
        <!-- /Banner -->

        <!-- Main -->
        <div id="page">

            <!-- Extra -->
            <div id="marketing" class="container">
                <div class="row">
                    
                    <%
                        List<BusinessObject.LegendsDetail> legendsDetails = BusinessLogic.LegendsDetailBL.GetAll();
                        
                        for(BusinessObject.LegendsDetail legendsDetail : legendsDetails){
                            
                    %>
                    <div class="3u">
                        <section>
                            <header>
                                <h2> <%= legendsDetail.getName() %> </h2>
                            </header>
                                <p style="height:50px;overflow:hidden;" class="subtitle"  > <%= legendsDetail.getDetail() %> </p>
                            <p><a ><img width="282" height="150" src="<%= legendsDetail.getImageUrl() %>" alt="<%= legendsDetail.getName() %>"></a></p>
                            <a href="<%= request.getContextPath()+"/"+legendsDetail.getName() %>" class="button">More</a>
                        </section>
                    </div>
                    <%}%>
                </div>
            </div>
            <!-- /Extra -->

            <!-- Main -->
            <div id="main" class="container">
                <div class="row">
                    <div class="6u">
                        <section>
                            <header>
                                <h2>Integer gravida nibh quis urna</h2>
                                <span class="byline">Augue praesent a lacus at urna congue rutrum</span>
                            </header>
                            <p>This is <strong>Ex Machina</strong>, a responsive HTML5 site template freebie by <a href="http://templated.co">TEMPLATED</a>. Released for free under the <a href="http://templated.co/license">Creative Commons Attribution</a> license, so use it for whatever (personal or commercial) &ndash; just give us credit! Check out more of our stuff at <a href="http://templated.co">our site</a> or follow us on <a href="http://twitter.com/templatedco">Twitter</a>.</p>
                            <p>Sed etiam vestibulum velit, euismod lacinia quam nisl id lorem. Quisque erat. Vestibulum pellentesque, justo mollis pretium suscipit, justo nulla blandit libero, in blandit augue justo quis nisl. Fusce mattis viverra elit. Fusce quis tortor. Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget lorem ipsum dolor. Donec placerat odio vel elit. Nullam ante orci, pellentesque eget, tempus quis, ultrices in, est. Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat. Sed etiam vestibulum velit, euismod lacinia quam nisl id lorem. Quisque erat.</p>
                            <p>Sed etiam vestibulum velit, euismod lacinia quam nisl id lorem. Quisque erat. Vestibulum pellentesque, justo mollis pretium suscipit, justo nulla blandit libero, in blandit augue justo quis nisl. Fusce mattis viverra elit. Fusce quis tortor. Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget lorem ipsum dolor. Donec placerat odio vel elit. Nullam ante orci, pellentesque eget, tempus quis, ultrices in, est. Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat. Sed etiam vestibulum velit, euismod lacinia quam nisl id lorem. Quisque erat.</p>
                            <a href="#" class="button">More Details</a>
                        </section>
                    </div>
           
                    <div class="3u">
                        <section class="sidebar">
                            <header>
                                <h2>Feugiat Tempus</h2>
                            </header>
                            <ul class="style1">
                                <li><a href="#">Maecenas luctus lectus at sapien</a></li>
                                <li><a href="#">Etiam rhoncus volutpat erat</a></li>
                                <li><a href="#">Donec dictum metus in sapien</a></li>
                                <li><a href="#">Nulla luctus eleifend purus</a></li>
                                <li><a href="#">Maecenas luctus lectus at sapien</a></li>
                            </ul>
                        </section>
                        <section class="sidebar">
                            <header>
                                <h2>Nulla luctus eleifend</h2>
                            </header>
                            <ul class="style1">
                                <li><a href="#">Maecenas luctus lectus at sapien</a></li>
                                <li><a href="#">Donec dictum metus in sapien</a></li>
                                <li><a href="#">Integer gravida nibh quis urna</a></li>
                                <li><a href="#">Etiam posuere augue sit amet nisl</a></li>
                                <li><a href="#">Mauris vulputate dolor sit amet nibh</a></li>
                            </ul>
                        </section>
                    </div>
                </div>
            </div>
            <!-- Main -->

        </div>
        <!-- /Main -->
        <div  style="height:15px;" >
            
        </div>
        <!-- Footer -->
        <jsp:include page="Partials/Shared/Footer.jsp" />

        <!-- /Footer -->


    </body>
</html>