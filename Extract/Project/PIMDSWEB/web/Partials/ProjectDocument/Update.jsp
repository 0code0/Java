<%@page import="java.util.List"%>

<form class="form-horizontal" action="/PIMDSWEB/UserProjectDocumentUpdate" method="post" enctype="multipart/form-data">

    <% BusinessObject.ProjectDocument projectDocument = BusinessLogic.ProjectDocumentBL.GetSingle(Integer.parseInt(request.getParameter("Id")));
        BusinessObject.ProjectDetail pDetail = BusinessLogic.ProjectDetailBL.GetSingle(projectDocument.getProjectId());
        BusinessObject.DocumentCategory DocCategory = BusinessLogic.DocumentCategoryBL.GetSingle(projectDocument.getDocumentCategoryId());

    %>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Select Project</label>
        <span style="margin-left: 400px;margin-top: 10px;color: green;position: absolute;" ><%= pDetail.getName()%></span>
        <div class="col-sm-9">
            <select name="ProjectDetail" class="form-control" id="form-field-select-1" style="width: 373px;" >
                <option value="null">--Select--</option>
                <%
                    List<BusinessObject.ProjectDetail> projectDetails = BusinessLogic.ProjectDetailBL.GetAll();

                    for (BusinessObject.ProjectDetail projectDetail : projectDetails) {

                        String projectDetailstring = String.format("<option value='%s'>%s</option>", projectDetail.getId(), projectDetail.getName());

                        out.write(projectDetailstring);
                    }

                %>

            </select>
                <input type="hidden" value="<%= projectDocument.getProjectId() %>" name="OldProjectDetail"   />
        </div>

    </div>
                <input type="hidden" value="<%= projectDocument.getId() %>" name="Id"   />
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Select Document Category</label>
        <span style="margin-left: 400px;margin-top: 10px;color: green;position: absolute;" ><%= DocCategory.getName()%></span>
        <div class="col-sm-9">
            <select name="DocumentCategory" class="form-control" id="form-field-select-1" style="width: 373px;" >
                <option value="null">--Select--</option>
                <%
                    List<BusinessObject.DocumentCategory> documentCategorys = BusinessLogic.DocumentCategoryBL.GetAll();

                    for (BusinessObject.DocumentCategory documentCategory : documentCategorys) {

                        String documentCategorystring = String.format("<option value='%s'>%s</option>", documentCategory.getId(), documentCategory.getName());

                        out.write(documentCategorystring);
                    }

                %>

            </select>
                <input type="hidden" value="<%= projectDocument.getDocumentCategoryId() %>" name="OldDocumentCategory"   />
        </div>
    </div>

    <div class="space-4"></div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right"  for="form-field-1-1">Document Title</label>

        <div class="col-sm-9">
            <input type="text" name="Title" placeholder="Title" value="<%= projectDocument.getTitle()%>" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Version</label>

        <div class="col-sm-9">
            <input type="text" name="Version" placeholder="Version" value="<%= projectDocument.getVersion()%>" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Source</label>

        <div class="col-sm-9">
            <input type="text" name="Source" placeholder="Source" value="<%= projectDocument.getSource()%>" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Description</label>

        <div class="col-sm-9">
            <textarea class="form-control" name="Description"  placeholder="Description" style="width: 378px;" rows="5">
                <%= projectDocument.getDescription()%>
            </textarea>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Author</label>

        <div class="col-sm-9">
            <input type="text" name="Author" placeholder="Author Name" value="<%= projectDocument.getAuthor()%>" style="width: 378px;" />

        </div>
    </div>
            

  <input type="hidden" value="<%= projectDocument.getURL() %>" name="OldUrl"   />
  <input type="hidden" value="<%= projectDocument.getName() %>" name="OldName"   />
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