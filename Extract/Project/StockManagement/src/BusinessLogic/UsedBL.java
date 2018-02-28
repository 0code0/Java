/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Used;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class UsedBL {
    
        public static boolean Add(Used Used) {

        return DataAccess.UsedDA.Add(Used);
    }

    public static boolean Update(Used Used) {

        return DataAccess.UsedDA.Update(Used);
    }

    public static boolean Delete(Used Used) {
        
        return DataAccess.UsedDA.Delete(Used);
    }

    public static Used GetSingle(int Id) {

        return DataAccess.UsedDA.GetSingle(Id);
    }

    public static List<Used> GetAll() {

        return DataAccess.UsedDA.GetAll();
    }
    
    public static List<Used> GetAllByPartId(int PartId) {
        
        return DataAccess.UsedDA.GetAllByPartId(PartId);
    }
}
