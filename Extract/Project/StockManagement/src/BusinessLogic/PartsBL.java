/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Parts;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class PartsBL {
    
    public static boolean Add(Parts parts) {

        return DataAccess.PartsDA.Add(parts);
    }

    public static boolean Update(Parts parts) {
       
        return DataAccess.PartsDA.Update(parts);
    }

    public static boolean Delete(Parts parts) {

        return DataAccess.PartsDA.Delete(parts);
    }

    public static Parts GetSingle(int Id) {

        return DataAccess.PartsDA.GetSingle(Id);
    }

    public static List<Parts> GetAll() {

        return DataAccess.PartsDA.GetAll();
    }
   
    public static List<Parts> GetAllByRackId(int RackId) {
    
        return DataAccess.PartsDA.GetAllByRackId(RackId);
    }
    
    public static List<Parts> Search(String KeyWord) {
    
        return DataAccess.PartsDA.Search(KeyWord);
    }
}
