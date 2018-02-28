/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Randd;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class RandDBL {

    public static boolean Add(Randd randd) {

        return DataAccess.RandDDA.Add(randd);
    }

    public static boolean Update(Randd randd) {

        return DataAccess.RandDDA.Update(randd);
    }

    public static boolean Delete(Randd randd) {

        return DataAccess.RandDDA.Delete(randd);
    }

    public static Randd GetSingle(int Id) {

        return DataAccess.RandDDA.GetSingle(Id);
    }

    public static List<Randd> GetAll() {

        return DataAccess.RandDDA.GetAll();
    }
}
