<%@page import="java.util.List"%>
<form action="" method="post" >
    <h2>Add Legend RandD</h2>
    <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>

            <tr>
                <td> Legend Name </td>
                <td>
                    <select style="width: 150px;" name="LegendName">
                        <option >------------Select------------</option>
                        <%List<BusinessObject.LegendsDetail> legendsDetails = BusinessLogic.LegendsDetailBL.GetAll();

                            for (BusinessObject.LegendsDetail legendsDetail : legendsDetails) {

                                String Name = String.format("<option value='%s'>%s</option>", legendsDetail.getId(), legendsDetail.getName());

                                out.write(Name);
                            }


                        %>

                    </select>
                </td>
            </tr>

            <tr>
                <td>Title</td>
                <td><input type="text" name="Title" width="100px" /></td>
            </tr>

            <tr>
                <td>Detail</td>
                <td> <textarea name="Detail" cols="30" rows="10" ></textarea> </td>
            </tr>

            <tr>
                <td>Url</td>
                <td><input type="text" name="Url" style="width: 300px;" /></td>
            </tr>


        </tbody>
    </table>
    <br>
    <input class="btn btn-primary" type="submit" value="Add" name="op" />
</form>