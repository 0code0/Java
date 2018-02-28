
<%@page import="java.util.List"%>
<% BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>

<form action="/PIMDSWEB/EditProjectDetail" method="post" enctype="multipart/form-data" >
    <input type="hidden" name="Id" value="<%= projectDetail.getId()%>" /> 

    <h2>Update Project Detail</h2>
    <table width="100%" class="table table-striped table-bordered">

      <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" value="<%= projectDetail.getName() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>IP Need</td>
                <td><input type="text" name="IPNeed" value="<%= projectDetail.getIPNeed() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>Technology</td>
                <td><input type="text" name="Technology" value="<%= projectDetail.getTechnology() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>Version</td>
                <td><input type="text" name="Version" value="<%= projectDetail.getVersion() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>Product</td>
                <td><input type="text" name="Product" value="<%= projectDetail.getProduct() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>Division</td>
                <td><input type="text" name="Division" value="<%= projectDetail.getDivision() %>" width="100px" /></td>
            </tr>
            <tr>
                <td>Document</td>
                <td><a href="<%= projectDetail.getURL() %>" target="_blank">Click to download</a>
                    <input type="file" name="Url" />
                </td>
            </tr>
      <input type="hidden" name="OldUrl" name="OldUrl" value="<%= projectDetail.getURL() %>" />
            <tr>
                <td>Project Category</td>
                <td>
                    <select style="width: 150px;" name="ProjectCategory" onchange="getProjectCategory(this.value)" >
                        <option value="null">-----Select-----</option>
                        <%
                            List<BusinessObject.ProjectCategory> projectCategory = BusinessLogic.ProjectCategoryBL.GetAllnull();

                            for (int i = 0; i < projectCategory.size(); i++) {

                                String Name = String.format("<option value='%s'>%s</option>", projectCategory.get(i).getId(), projectCategory.get(i).getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
      <input type="hidden" value="<%= projectDetail.getProjectCategoryId() %>" name="OldProjectCategory" />
            <tr>
                <td>Project Sub Category</td>
                <td id="ShowProjectCategory">

           
                </td>
            </tr>

            <tr>
                <td>Project Class</td>
                <td>

                    <select style="width: 150px;" name="ProjectClass" onchange="getProjectClass(this.value)">
                        <option value="null">-----Select-----</option>
                        <%  List<BusinessObject.ProjectClass> projectClass = BusinessLogic.ProjectClassBL.GetAllnull();
                            for (int i = 0; i < projectClass.size(); i++) {
                                String Name = String.format("<option value='%s'>%s</option>", projectClass.get(i).getId(), projectClass.get(i).getName());
                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>
            <input type="hidden" value="<%= projectDetail.getProjectClassId() %>" name="OldProjectClass" />

            <tr>
                <td>Project Sub Class</td>
                <td id="ShowProjectClass">

                </td>
            </tr>
        </tbody>
    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>
            
            <script>
function getProjectCategory(str) {
  var xhttp;
  if (str == "null") {
       return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("ShowProjectCategory").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "/PIMDSWEB/GetSubValue?Id="+str, true);
  xhttp.send();
}
function getProjectClass(str) {
  var xhttp;
  if (str == "null") {
       return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("ShowProjectClass").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "/PIMDSWEB/GetSubValue?Id="+str, true);
  xhttp.send();
}
</script>
