<%@page import="java.util.List"%>



<form action="/PIMDSWEB/UploadDocument" method="post" enctype="multipart/form-data" >
    <h2>Add New Document</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" width="300px" />
                </td>
            </tr>
            <tr>
                <td>Url</td>
                <td>
                    <input type="file" name="Url" width="100px" /></br>
                    --OR--</br>
                    <input type="text" name="DirectUpload" width="300px" />
                    
                </td>
            </tr>


            <tr>
                <td> Parent </td>
                <td>
                    <select style="width: 150px;" name="Parent">
                        <option value="null" >------------Select------------</option>
                        <%List<BusinessObject.Document> documents = BusinessLogic.DocumentBL.GetAll();

                            for (BusinessObject.Document document : documents) {
                                String Name = String.format("<option value='%s'>%s</option>", document.getId(), document.getName());

                                out.write(Name);
                            }


                        %>

                    </select>
                </td>
            </tr>
        </tbody>
    </table>
    <br>

    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>
