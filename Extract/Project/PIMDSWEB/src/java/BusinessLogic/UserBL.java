/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.User;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class UserBL {

    public static boolean Add(User user) {

        return DataAccess.UserDA.Add(user);

    }

    public static boolean Update(User user) {

        return DataAccess.UserDA.Update(user);

    }

    public static boolean Delete(User user) {

        return DataAccess.UserDA.Delete(user);

    }

    public static User GetSingle(int Id) {

        return DataAccess.UserDA.GetSingle(Id);
    }

    public static List<User> GetAll() {

        return DataAccess.UserDA.GetAll();
    }
    
    public static List<User> GetAllByUserId(int Id) {
    
        return DataAccess.UserDA.GetAllByUserId(Id);
    }
    public static User IsValidUser(String UserName) {
    
        return DataAccess.UserDA.IsValidUser(UserName);
    }
    
    public static List<User> GetAllUserByProjectCategory(int ProjectCategoryId) {
    
        return DataAccess.UserDA.GetAllUserByProjectCategory(ProjectCategoryId);
    }
    
    
}
