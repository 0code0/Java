<%@page import="java.util.List"%>
<form class="form-horizontal" action="/PIMDSWEB/UserUploadProjectDocument" method="post" enctype="multipart/form-data">

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Select Project</label>

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
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Select Document Category</label>

        <div class="col-sm-9">
            <select name="DocumentCategory" class="form-control" id="form-field-select-1" style="width: 373px;" >
                <option value="null">--Select--</option>
                <%                                                    List<BusinessObject.DocumentCategory> documentCategorys = BusinessLogic.DocumentCategoryBL.GetAll();

                    for (BusinessObject.DocumentCategory documentCategory : documentCategorys) {

                        String documentCategorystring = String.format("<option value='%s'>%s</option>", documentCategory.getId(), documentCategory.getName());

                        out.write(documentCategorystring);
                    }

                %>

            </select>
        </div>
    </div>

    <div class="space-4"></div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Document Title</label>

        <div class="col-sm-9">
            <input type="text" name="Title" placeholder="Title" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Author</label>

        <div class="col-sm-9">
            <input type="text" name="Author" placeholder="Author Name" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Source</label>

        <div class="col-sm-9">
            <input type="text" name="Source" placeholder="Source" style="width: 378px;" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Version</label>

        <div class="col-sm-9">
            <input type="text" name="Version" placeholder="Version" style="width: 378px;" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Description</label>

        <div class="col-sm-9">
            <textarea class="form-control" name="Description" placeholder="Description" style="width: 378px;" rows="5"></textarea>
        </div>
    </div>


    <div style="margin-left: 24.5%;width: 45%;">
        <div class="form-group">
            <div class="col-sm-9">
                <div class="widget-main">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input type="file" name="Url"  id="id-input-file-3" multiple="" />
                            --OR--
                            <input type="text" name="DirectUserFileUpload" placeholder="UrlPath" style="width: 378px;" />
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>    


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