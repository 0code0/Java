

<% BusinessObject.Randd randd = BusinessLogic.RandDBL.GetSingle(Integer.parseInt(request.getParameter("Id")));

    BusinessObject.LegendsDetail legendsDetail = BusinessLogic.LegendsDetailBL.GetSingle(randd.getLegendsDetailId());
%>                

<h2>Selected Project Category</h2>
<table border="1" width="100%" class="table table-striped table-bordered">

    <tbody>

        <tr>
            <td> Legend Name </td>
            <td> <%= legendsDetail.getName()%> </td>
        </tr>

        <tr>
            <td> Title </td>
            <td> <%= randd.getTitle()%> </td>
        </tr>

        <tr>
            <td> Detail </td>
            <td style="overflow-x: auto;" > <%= randd.getDetail()%> </td>
        </tr>

        <tr>
            <td> Is Approved </td>
            <td> <%= randd.getBase().getIsApproved() %> </td>
        </tr>

        <tr>
            <td> Is Deleted </td>
            <td> <%= randd.getBase().getIsApproved() %> </td>
        </tr>

        <tr>
            <td> Created On </td>
            <td> <%= randd.getBase().getCreatedOn() %> </td>
        </tr>

        <tr>
            <td> Created By </td>
            <td> <%= randd.getBase().getCreatedBy() %> </td>
        </tr>

    </tbody>
</table>