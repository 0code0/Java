<%@page import="java.util.List"%>
<% BusinessObject.ProjectDetail projectDetail = BusinessLogic.ProjectDetailBL.GetSingle(Integer.parseInt(request.getParameter("Id")));
    BusinessObject.ProjectCategory projectCategory = BusinessLogic.ProjectCategoryBL.GetSingle(projectDetail.getProjectCategoryId());
    BusinessObject.ProjectClass projectClass = BusinessLogic.ProjectClassBL.GetSingle(projectDetail.getProjectClassId());
%>
<form class="form-horizontal" action="/PIMDSWEB/UserProjectUpdate" method="post" enctype="multipart/form-data">

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Project Name</label>

        <div class="col-sm-9">
            <input type="text" id="form-field-1" value="<%= projectDetail.getName()%>" placeholder="Project Name" name="Name" class="col-xs-10 col-sm-5" />

        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Project Category</label>
<span style="margin-left: 400px;margin-top: 10px;color: green;position: absolute;" ><%= projectCategory.getName()%></span>
        
        <div class="col-sm-9">
            <select name="ProjectCategory" class="form-control" id="form-field-select-1" style="width: 373px;" onchange="getProjectCategory(this.value)">
                <option value="null">--Select--</option>
                <%
                    List<BusinessObject.ProjectCategory> projectcategory = BusinessLogic.ProjectCategoryBL.GetAll();

                    for (int i = 0; i < projectcategory.size(); i++) {

                        String Name = String.format("<option value='%s'>%s</option>", projectcategory.get(i).getId(), projectcategory.get(i).getName());

                        out.write(Name);
                    }

                %>

            </select>
        </div>
    </div>
    <input type="hidden" name="OldProjectCategory" value="<%= projectDetail.getProjectCategoryId()%>" />

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Project Class</label>
<span style="margin-left: 400px;margin-top: 10px;color: green;position: absolute;" > <%= projectClass.getName()%> </span>
        
        <div class="col-sm-9">

            <select class="form-control" id="form-field-select-1" style="width: 373px;" name="ProjectClass" onchange="getProjectSubClass(this.value)">
                <option value="null">-----Select-----</option>
                <% List<BusinessObject.ProjectClass> projectclass = BusinessLogic.ProjectClassBL.GetAll();

                    for (int i = 0; i < projectclass.size(); i++) {

                        String Name = String.format("<option value='%s'>%s</option>", projectclass.get(i).getId(), projectclass.get(i).getName());

                        out.write(Name);
                    }

                %>

            </select>

        </div>
        <input type="hidden" name="OldProjectClass" value="<%= projectDetail.getProjectClassId()  %>" />
    </div>

    <div class="space-4"></div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">IP Need</label>

        <div class="col-sm-9">
            <input type="text" name="IPNeed" id="form-field-1" value="<%= projectDetail.getIPNeed() %>" placeholder="IP Need" class="col-xs-10 col-sm-5" />

        </div>
    </div>
    <div class="space-4"></div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Technology</label>

        <div class="col-sm-9">
            <input type="text" id="form-field-1" name="Technology" value="<%= projectDetail.getTechnology() %>" placeholder="Technology" class="col-xs-10 col-sm-5" />

        </div>
    </div>
    <div class="space-4"></div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Version</label>

        <div class="col-sm-9">
            <input type="text" id="form-field-1" name="Version" value="<%= projectDetail.getVersion() %>" placeholder="Version" class="col-xs-10 col-sm-5" />

        </div>
    </div>
    <div class="space-4"></div>


    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right"  for="form-field-1">Product</label>

        <div class="col-sm-9">
            <input type="text" id="form-field-1" name="Product" value="<%= projectDetail.getProduct() %>" placeholder="Product" class="col-xs-10 col-sm-5" />

        </div>
    </div>
    <div class="space-4"></div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Division</label>

        <div class="col-sm-9">
            <input type="text" id="form-field-1" name="Division" value="<%= projectDetail.getDivision() %>" placeholder="Division" class="col-xs-10 col-sm-5" />

        </div>
    </div>
    <div class="space-4"></div>
    
    <input type="hidden" name="OldUrl" value="<%= projectDetail.getURL() %>" />
    <input type="hidden" name="Id" value="<%= projectDetail.getId() %>" />

    <div class="clearfix form-actions">
        <div class="col-md-offset-3 col-md-9">
            <input type="submit" class="btn btn-info bigger-150 "  />
            &nbsp; &nbsp; &nbsp;
            <button class="btn" type="reset">
                <i class="ace-icon fa fa-undo bigger-110"></i>
                Reset
            </button>
        </div>
    </div>

</form>
