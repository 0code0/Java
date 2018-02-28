/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.ProjectCategory;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class ProjectCategoryBL {

    public static boolean Add(ProjectCategory projectCategory) {

        return DataAccess.ProjectCategoryDA.Add(projectCategory);
    }

    public static boolean Update(ProjectCategory projectCategory) {

        return DataAccess.ProjectCategoryDA.Update(projectCategory);
    }

    public static boolean Delete(ProjectCategory projectCategory) {

        return DataAccess.ProjectCategoryDA.Delete(projectCategory);
    }

    public static ProjectCategory GetSingle(int Id) {

        return DataAccess.ProjectCategoryDA.GetSingle(Id);
    }

    public static List<ProjectCategory> GetAll() {

        return DataAccess.ProjectCategoryDA.GetAll();
    }
    
    public static List<ProjectCategory> GetAllnull() {
    
        return DataAccess.ProjectCategoryDA.GetAllnull();
    }
    
    public static List<ProjectCategory> GetAllByParentId(int ParentId) {
    
        return DataAccess.ProjectCategoryDA.GetAllByParentId(ParentId);
    }
}
