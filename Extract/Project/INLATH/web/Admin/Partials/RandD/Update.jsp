<%@page import="java.util.List"%>
<% BusinessObject.LegendsCategory legendsCategory = BusinessLogic.LegendsCategoryBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                


<form action="" method="post" >
      <input type="hidden" name="Id" value="<%= legendsCategory.getId()%>" /> 
    <h2>Add New Legend Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" width="100px" value="<%= legendsCategory.getName() %>" /></td>
            </tr>


        </tbody>
    </table>
    <br>
    <input class="btn btn-primary" type="submit" value="Update" name="op" />
</form>