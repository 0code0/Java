<% BusinessObject.ProjectDetail projectDetails = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                
<h2>Delete</h2>

<form action="">
    
    <input type="hidden" name="Id" value="<%= projectDetails.getId() %>" /> 
  
    <b>
        Are you sure you want to delete - <%= projectDetails.getName() %> ?
        
    </b>
    
    <br>
    
    <b>
        All data will be lost and cannot be recovered.
    </b>
    
    <br>
<input type="submit" value="Yes" name="delete_yes" class="btn btn-danger"> 
<input type="submit" value="No" name="delete_no" class="btn btn-danger"> 
<br>
</form>