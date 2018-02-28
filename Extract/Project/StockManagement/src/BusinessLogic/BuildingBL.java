/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Building;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class BuildingBL {

    public static boolean Add(Building building) {

        return DataAccess.BuildingDA.Add(building);
    }

    public static boolean Update(Building building) {

        return DataAccess.BuildingDA.Update(building);
    }

    public static boolean Delete(Building building) {
        
        return DataAccess.BuildingDA.Delete(building);
    }

    public static Building GetSingle(int Id) {

        return DataAccess.BuildingDA.GetSingle(Id);
    }

    public static List<Building> GetAll() {

        return DataAccess.BuildingDA.GetAll();
    }
}
