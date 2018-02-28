/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.ProjectClass;
import java.util.List;


/**
 *
 * @author singhj1
 */
public class ProjectClassBL {

    public static boolean Add(ProjectClass projectClass) {

        return DataAccess.ProjectClassDA.Add(projectClass);
    }

    public static boolean Update(ProjectClass projectClass) {

        return DataAccess.ProjectClassDA.Update(projectClass);
    }

    public static boolean Delete(ProjectClass projectClass) {

        return DataAccess.ProjectClassDA.Delete(projectClass);
    }

    public static ProjectClass GetSingle(int Id) {

        return DataAccess.ProjectClassDA.GetSingle(Id);
    }

    public static List<ProjectClass> GetAll() {

        return DataAccess.ProjectClassDA.GetAll();
    }
    
    public static List<ProjectClass> GetAllnull() {
    
        return DataAccess.ProjectClassDA.GetAllnull();
    }
    public static List<ProjectClass> GetAllByParentId(int ParentId) {
    
        return DataAccess.ProjectClassDA.GetAllByParentId(ParentId);
    }
}
