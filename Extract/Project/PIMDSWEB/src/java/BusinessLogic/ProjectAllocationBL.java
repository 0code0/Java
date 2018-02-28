/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.ProjectAllocation;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class ProjectAllocationBL {

    public static boolean Add(ProjectAllocation projectAllocation) {

        return DataAccess.ProjectAllocationDA.Add(projectAllocation);
    }

    public static boolean Update(ProjectAllocation projectAllocation) {

        return DataAccess.ProjectAllocationDA.Update(projectAllocation);
    }

    public static boolean Delete(ProjectAllocation projectAllocation) {

        return DataAccess.ProjectAllocationDA.Delete(projectAllocation);
    }

    public static ProjectAllocation GetSingle(int Id) {

        return DataAccess.ProjectAllocationDA.GetSingle(Id);
    }

    public static List<ProjectAllocation> GetAll() {

        return DataAccess.ProjectAllocationDA.GetAll();
    }

    public static List<ProjectAllocation> GetAllByProjectDetailId(int ProjectDetailId) {

        return DataAccess.ProjectAllocationDA.GetAllByProjectDetailId(ProjectDetailId);
    }

    public static ProjectAllocation GetSingleByProjectDetailId(int ProjectDetailId) {

        return DataAccess.ProjectAllocationDA.GetSingleByProjectDetailId(ProjectDetailId);
    }
}
