

<% BusinessObject.Document document = BusinessLogic.DocumentBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>                

<h2>Selected Document</h2>
<table border="1" width="100%" class="table table-striped table-bordered">

    <tbody>

        <tr>
            <td>Name</td>
            <td><%= document.getName()%></td>
        </tr>

        <tr>
            <td> Parent </td>

            <td><%
                if (!(document.getParentId() == null)) {

                    BusinessObject.Document ParentName = BusinessLogic.DocumentBL.GetSingle(document.getParentId());
                    out.println(ParentName.getName());
                } else {
                    out.println("null");
                }
                %></td>
        </tr>


        <tr>
            <td>Url</td>
            <td><% if(document.getURL() != null){%>
            <a target="_blank" href="<%= document.getURL()%>"> Click to download </a></td>
                
            <%}else{%>

    <span style="color: red;"> No data found </span>
<%} %>
                
        </tr>

        <tr>
            <td>Approved</td>
            <td><%= document.getBase().getIsApproved()%></td>
        </tr>

        <tr>
            <td>Deleted</td>
            <td><%= document.getBase().getIsDeleted()%></td>
        </tr>

        <tr>
            <td>Created On</td>
            <td><%= document.getBase().getCreatedOn()%></td>
        </tr>

        <tr>
            <td>User</td>
            <td><%= document.getBase().getCreatedBy()%></td>
        </tr>
    </tbody>
</table>