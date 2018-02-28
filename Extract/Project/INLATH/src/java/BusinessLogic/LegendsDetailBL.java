/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.LegendsDetail;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class LegendsDetailBL {

    public static boolean Add(LegendsDetail legendsDetail) {

        return DataAccess.LegendsDetailDA.Add(legendsDetail);
    }

    public static boolean Update(LegendsDetail legendsDetail) {

        return DataAccess.LegendsDetailDA.Update(legendsDetail);
    }

    public static boolean Delete(LegendsDetail legendsDetail) {

        return DataAccess.LegendsDetailDA.Delete(legendsDetail);
    }

    public static LegendsDetail GetSingle(int Id) {

        return DataAccess.LegendsDetailDA.GetSingle(Id);
    }

    public static List<LegendsDetail> GetAll() {

        return DataAccess.LegendsDetailDA.GetAll();
    }

    public static List<LegendsDetail> GetAllRandom() {

        return DataAccess.LegendsDetailDA.GetAllRandom();
    }
    
    public static List<LegendsDetail> GetAllByProjectCategory(int LegendCategoryId) {
    
        return DataAccess.LegendsDetailDA.GetAllByProjectCategory(LegendCategoryId);
    }
}
