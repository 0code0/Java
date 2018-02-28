<%@page import="java.util.List"%>

<form action="/PIMDSWEB/UploadProjectDetail" method="post" enctype="multipart/form-data" >
    <h2>Add New Project</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td>Name</td>
                <td><input type="text" name="Name" width="100px" /></td>
            </tr>
            <tr>
                <td>IP Need</td>
                <td><input type="text" name="IPNeed" width="100px" /></td>
            </tr>
            <tr>
                <td>Technology</td>
                <td><input type="text" name="Technology" width="100px" /></td>
            </tr>
            <tr>
                <td>Version</td>
                <td><input type="text" name="Version" width="100px" /></td>
            </tr>
            <tr>
                <td>Product</td>
                <td><input type="text" name="Product" width="100px" /></td>
            </tr>
            <tr>
                <td>Division</td>
                <td><input type="text" name="Division" width="100px" /></td>
            </tr>
            <tr>
                <td>Document</td>
                <td><input type="file" name="Url" />
                 
                </td>
            </tr>
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
                        <%  List<BusinessObject.ProjectClass> projectClass = BusinessLogic.ProjectClassBL.GetAll();
                            for (int i = 0; i < projectClass.size(); i++) {
                                String Name = String.format("<option value='%s'>%s</option>", projectClass.get(i).getId(), projectClass.get(i).getName());
                                out.write(Name);
                            }

                        %>

                    </select>
                </td>
            </tr>

            <tr>
                <td>Project Sub Class</td>
                <td id="ShowProjectClass">

                </td>
            </tr>
        </tbody>
    </table>
    <br>
    <input class="btn btn-primary" type="submit" value="Add" name="op" />
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
