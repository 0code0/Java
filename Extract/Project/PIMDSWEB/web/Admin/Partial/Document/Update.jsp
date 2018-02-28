
<%@page import="java.util.List"%>
<% BusinessObject.Document document = BusinessLogic.DocumentBL.GetSingle(Integer.parseInt(request.getParameter("Id")));%>
<form action="/PIMDSWEB/EditDocument" method="post" enctype="multipart/form-data" >

    <input type="hidden" name="Id" value="<%= document.getId()%>" /> 

    <h2>Update Document</h2>
    <table width="100%" class="table table-striped table-bordered">
        <tbody>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="<%= document.getName()%>" width="300px" />
                </td>
            </tr>

            <tr>
                <td> Url s</td>
                <td>
                    <a target="_blank" href="<%= document.getURL()%>">Click to see the Document</a>
                    <input type="file" name="Url" width="100px" /></br>
                    --OR--</br>
                    <input type="text" name="DirectUpload" width="300px" />
                    <input type="hidden" value="<%= document.getURL()%>" name="OldUrl" />
                </td>  
            </tr>

            <tr>
                <td> Parent </td>
                <td><span style="color: red;">*</span>
                    <select style="width: 150px;" name="Parent">
                        <option value="null" >------------Select------------</option>
                        <%List<BusinessObject.Document> documents = BusinessLogic.DocumentBL.GetAll();

                            for (BusinessObject.Document updatedocument : documents) {
                                String Name = String.format("<option value='%s'>%s</option>", updatedocument.getId(), updatedocument.getName());

                                out.write(Name);
                            }

                        %>

                    </select>
                    <%if (!(document.getParentId() == null)) {

                            BusinessObject.Document ParentName = BusinessLogic.DocumentBL.GetSingle(document.getParentId());
                            out.println(ParentName.getName());
                        } else {
                            out.println("null");
                        }%>
                </td>
            </tr>
        </tbody>

    </table>

    <input type="submit" value="Update" name="op"  class="btn btn-primary"/>

</form>