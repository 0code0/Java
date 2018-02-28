/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.LegendsCategory;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class LegendsCategoryBL {

    public static boolean Add(LegendsCategory legendsCategory) {

        return DataAccess.LegendsCategoryDA.Add(legendsCategory);

    }

    public static boolean Update(LegendsCategory legendsCategory) {

        return DataAccess.LegendsCategoryDA.Update(legendsCategory);
    }

    public static boolean Delete(LegendsCategory legendsCategory) {

        return DataAccess.LegendsCategoryDA.Delete(legendsCategory);

    }

    public static LegendsCategory GetSingle(int Id) {

        return DataAccess.LegendsCategoryDA.GetSingle(Id);
    }

    public static List<LegendsCategory> GetAll() {

        return DataAccess.LegendsCategoryDA.GetAll();
    }

}
