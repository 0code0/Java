/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Block;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class BlockBL {
    
    public static boolean Add(Block block) {

        return DataAccess.BlockDA.Add(block);
    }

    public static boolean Update(Block block) {
       
        return DataAccess.BlockDA.Update(block);
    }

    public static boolean Delete(Block block) {

        return DataAccess.BlockDA.Delete(block);
    }

    public static Block GetSingle(int Id) {

        return DataAccess.BlockDA.GetSingle(Id);
    }

    public static List<Block> GetAll() {

        return DataAccess.BlockDA.GetAll();
    }
    
    public static List<Block> GetAllByBuildingId(int BuildingId) {
    
        return DataAccess.BlockDA.GetAllByBuildingId(BuildingId);
    }
}
