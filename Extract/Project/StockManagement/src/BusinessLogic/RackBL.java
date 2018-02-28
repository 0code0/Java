/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Rack;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class RackBL {
    
        public static boolean Add(Rack rack) {

        return DataAccess.RackDA.Add(rack);
    }

    public static boolean Update(Rack rack) {

        return DataAccess.RackDA.Update(rack);
    }

    public static boolean Delete(Rack rack) {
        
        return DataAccess.RackDA.Delete(rack);
    }

    public static Rack GetSingle(int Id) {

        return DataAccess.RackDA.GetSingle(Id);
    }

    public static List<Rack> GetAll() {

        return DataAccess.RackDA.GetAll();
    }
    
    public static List<Rack> GetAllByBlockId(int BlockId) {
    
        return DataAccess.RackDA.GetAllByBlockId(BlockId);
    }
}
