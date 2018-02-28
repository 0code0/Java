/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.EmployeeType;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class EmployeeTypeBL {

    public static boolean Add(EmployeeType employeeType) {

        return DataAccess.EmployeeTypeDA.Add(employeeType);

    }

    public static boolean Update(EmployeeType employeeType) {

        return DataAccess.EmployeeTypeDA.Update(employeeType);
    }

    public static boolean Delete(EmployeeType employeeType) {

        return DataAccess.EmployeeTypeDA.Delete(employeeType);
    }

    public static EmployeeType GetSingle(int Id) {

        return DataAccess.EmployeeTypeDA.GetSingle(Id);
    }

    public static List<EmployeeType> GetAll() {

        return DataAccess.EmployeeTypeDA.GetAll();
    }
}
