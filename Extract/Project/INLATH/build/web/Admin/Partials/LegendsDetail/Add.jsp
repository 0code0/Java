<%@page import="java.util.List"%>
<form action="/INLATH/AddLegendsDetail" method="post" enctype="multipart/form-data" >
    <h2>Add New Legend Category</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td> Category </td>
                <td>
                    <select style="width: 150px;" name="LegendsCategory">
                        <option >------------Select------------</option>
                        <%List<BusinessObject.LegendsCategory> legendsCategorys = BusinessLogic.LegendsCategoryBL.GetAll();

                            for (BusinessObject.LegendsCategory legendsCategory : legendsCategorys) {

                                String Name = String.format("<option value='%s'>%s</option>", legendsCategory.getId(), legendsCategory.getName());

                                out.write(Name);
                            }


                        %>

                    </select>
                </td>
            </tr>
            <tr>
                <td> Name </td>
                <td><input type="text" name="Name" style="width: 300px;" /></td>
            </tr>
            <tr>
                <td> Born </td>
                <td><input type="text" name="Born" style="width: 300px;" /></td>
            </tr>
            <tr>
                <td> Detail </td>
                <td> <textarea name="Detail" cols="100" rows="20" ></textarea> </td>
            </tr>
            <tr>
                <td> Family Detail </td>
                <td> <textarea name="FamilyDetail" cols="100" rows="20" ></textarea> </td>
            </tr>
            <tr>
                <td> Image Url </td>
                <td><input type="file" name="Url" /></td>
            </tr>
            <tr>
                <td> More Detail Url </td>
                <td><input type="text" name="MoreDetailUrl" style="width: 300px;" /></td>
            </tr>


        </tbody>
    </table>
    <br>
    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>