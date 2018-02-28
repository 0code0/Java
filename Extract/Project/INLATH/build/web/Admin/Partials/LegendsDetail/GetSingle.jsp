

<% BusinessObject.LegendsDetail legendsDetail = BusinessLogic.LegendsDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id"))); 
    
    BusinessObject.LegendsCategory  legendsCategory = BusinessLogic.LegendsCategoryBL.GetSingle(Integer.parseInt(legendsDetail.getCategoryId()));
%>                
    
 <table border="1" width="100%" class="table table-striped table-bordered">

        <tbody>
            <tr>
                <td> Category </td>
                <td> <%= legendsCategory.getName() %>         </td>
            </tr>
            <tr>
                <td> Name </td>
                <td> <%= legendsDetail.getName() %> </td>
            </tr>
            <tr>
                <td> Born </td>
                <td> <%= legendsDetail.getBorn() %> </td>
            </tr>
            <tr>
                <td> Detail </td>
                <td> <%= legendsDetail.getDetail() %> </td>
            </tr>
            <tr>
                <td> Family Detail </td>
                <td> <%= legendsDetail.getFamilyDetail() %> </td>
            </tr>
            <tr>
                <td> Image </td>
                <td> <img src="<%= legendsDetail.getImageUrl() %>" width="100" height="100" /> </td>
            </tr>
            <tr>
                <td> More Detail Url </td>
                <td> <%= legendsDetail.getMoreDetailUrl() %> </td>
            </tr>


        </tbody>
    </table>