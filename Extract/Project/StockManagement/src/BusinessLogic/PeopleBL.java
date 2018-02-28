/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.People;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class PeopleBL {
    
    public static boolean Add(People People) {

        return DataAccess.PeopleDA.Add(People);
    }

    public static boolean Update(People People) {
       
        return DataAccess.PeopleDA.Update(People);
    }

    public static boolean Delete(People People) {

        return DataAccess.PeopleDA.Delete(People);
    }

    public static People GetSingle(int Id) {

        return DataAccess.PeopleDA.GetSingle(Id);
    }

    public static List<People> GetAll() {

        return DataAccess.PeopleDA.GetAll();
    }
    
    public static List<People> GetAllByIdentified(String Identified) {
    
        return DataAccess.PeopleDA.GetAllByIdentified(Identified);
    }
}
