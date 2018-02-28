/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.ProjectDetail;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class ProjectDetailBL {

    public static boolean Add(ProjectDetail projectDetail) {

        return DataAccess.ProjectDetailDA.Add(projectDetail);
    }

    public static boolean Update(ProjectDetail projectDetail) {

        return DataAccess.ProjectDetailDA.Update(projectDetail);
    }

    public static boolean Delete(ProjectDetail projectDetail) {

        return DataAccess.ProjectDetailDA.Delete(projectDetail);
    }

    public static ProjectDetail GetSingle(int Id) {

        return DataAccess.ProjectDetailDA.GetSingle(Id);
    }

    public static List<ProjectDetail> GetAll() {

        return DataAccess.ProjectDetailDA.GetAll();
    }

    public static List<ProjectDetail> GetAllByProjectCategory(int ProjectCategoryId) {

        return DataAccess.ProjectDetailDA.GetAllByProjectCategory(ProjectCategoryId);
    }

    public static List<ProjectDetail> Running() {

        return DataAccess.ProjectDetailDA.Running();
    }

    public static List<ProjectDetail> Halt() {

        return DataAccess.ProjectDetailDA.Halt();
    }

    public static List<ProjectDetail> Complete() {

        return DataAccess.ProjectDetailDA.Complete();
    }
    
     public static List<ProjectDetail> GetAllByProjectDetailId(int Id) {
     
         return DataAccess.ProjectDetailDA.GetAllByProjectDetailId(Id);
     }

     public static List<ProjectDetail> GetAllProjectByUser( String UserName ) {
     
         return DataAccess.ProjectDetailDA.GetAllProjectByUser(UserName);
     }
     public static List<ProjectDetail> GetAllProjectDetailByProjectClass(int ProjectClassId) {
         
         return DataAccess.ProjectDetailDA.GetAllProjectDetailByProjectClass(ProjectClassId);
     }
}
