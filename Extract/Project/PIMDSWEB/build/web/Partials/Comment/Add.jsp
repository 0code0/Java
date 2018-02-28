<%@page import="java.util.List"%>
<form class="form-horizontal" action="/PIMDSWEB/UserUploadComment" method="get" enctype="multipart/form-data">

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"></label>

        <div class="col-sm-9">
            <select name="ProjectDocument" class="form-control" id="form-field-select-1" style="width: 373px;" >
                <option value="null">--Select Document--</option>
                <%
                    List<BusinessObject.ProjectDocument> projectDocuments = BusinessLogic.ProjectDocumentBL.GetAll();

                    for (BusinessObject.ProjectDocument projectDocument : projectDocuments) {

                        String Name = String.format("<option value='%s'>%s</option>", projectDocument.getId(), projectDocument.getName());

                        out.write(Name);
                    }

                %>

            </select>
        </div>
    </div>

    <div class="space-4"></div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"></label>

        <div class="col-sm-9">
            <select name="ParentComment" class="form-control" id="form-field-select-1" style="width: 373px;" >
                <option value="null">--Select Comment--</option>
                <% List<BusinessObject.Comment> comments = BusinessLogic.CommentBL.GetAllnull();

                    for (BusinessObject.Comment comment : comments) {

                        String Name = String.format("<option value='%s'>%s</option>", comment.getId(), comment.getComment());

                        out.write(Name);
                    }

                %>

            </select>
        </div>
    </div>


    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"></label>

        <div class="col-sm-9">
          
            <textarea class="form-control" name="Comment" placeholder="Comment" style="width: 378px;" rows="5"></textarea>

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
