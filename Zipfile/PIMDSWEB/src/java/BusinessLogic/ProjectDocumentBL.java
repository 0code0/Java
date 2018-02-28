/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.ProjectDocument;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class ProjectDocumentBL {

    public static boolean Add(ProjectDocument projectDocument) {

        return DataAccess.ProjectDocumentDA.Add(projectDocument);

    }

    public static boolean Update(ProjectDocument projectDocument) {
        return DataAccess.ProjectDocumentDA.Update(projectDocument);

    }

    public static boolean Delete(ProjectDocument projectDocument) {

        return DataAccess.ProjectDocumentDA.Delete(projectDocument);

    }

    public static ProjectDocument GetSingle(int Id) {

        return DataAccess.ProjectDocumentDA.GetSingle(Id);
    }

    public static List<ProjectDocument> GetAll() {

        return DataAccess.ProjectDocumentDA.GetAll();
    }

    public static List<ProjectDocument> GetAllByProject(int ProjectId) {

        return DataAccess.ProjectDocumentDA.GetAllByProject(ProjectId);
    }

    public static List<ProjectDocument> GetAllByProjectDocumentId(int Id) {

        return DataAccess.ProjectDocumentDA.GetAllByProjectDocumentId(Id);
    }

    public static List<ProjectDocument> GetAllProjectDocumentByUser(String UserName) {

        return DataAccess.ProjectDocumentDA.GetAllProjectDocumentByUser(UserName);
    }

}
