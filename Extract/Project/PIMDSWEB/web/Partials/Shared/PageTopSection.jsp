<%
    
    HttpSession httpsession = request.getSession();
    if(httpsession.getAttribute("UserName")==null){
    
    response.sendRedirect("/PIMDSWEB/index.jsp");
    return;
    }
    
%>
