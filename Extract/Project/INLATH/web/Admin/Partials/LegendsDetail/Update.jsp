<%@page import="java.util.List"%>
<% BusinessObject.LegendsDetail legendsDetail = BusinessLogic.LegendsDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); %>                

<form action="/INLATH/UpdateLegendsDetail" method="post" enctype="multipart/form-data" >
    <h2> Update Legend Category </h2>
    <table border="1" width="100%" class="table table-striped table-bordered">
        <input type="hidden" value="<%= legendsDetail.getId() %>" name="Id" />
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
                <td><input type="text" name="Name" value="<%= legendsDetail.getName()%>" style="width: 300px;" /></td>
            </tr>
            <tr>
                <td> Born </td>
                <td><input type="text" name="Born" value="<%= legendsDetail.getBorn()%>" style="width: 300px;" /></td>
            </tr>
            <tr>
                <td> Detail </td>
                <td> <textarea name="Detail" cols="100" rows="20" ><%= legendsDetail.getDetail()%></textarea> </td>
            </tr>
            <tr>
                <td> Family Detail </td>
                <td> <textarea name="FamilyDetail" cols="100" rows="20" ><%= legendsDetail.getFamilyDetail()%></textarea> </td>
            </tr>
            <tr>
                <td> Image Url </td>
                <td> <img src="<%= legendsDetail.getImageUrl()%>" alt="<%= legendsDetail.getName()%>" width="100" height="100" /> 

                    <input type="file" /> </td>
            </tr>
            <tr>
                <td> More Detail Url </td>
                <td><input type="text" name="MoreDetailUrl" value="<%= legendsDetail.getMoreDetailUrl()%>" style="width: 300px;" /></td>
            </tr>


        </tbody>
    </table>
    <br>
    <input class="btn btn-primary" type="submit" value="Update" name="op" />
</form>