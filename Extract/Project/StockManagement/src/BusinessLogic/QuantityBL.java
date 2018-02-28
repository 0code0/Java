/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Quantity;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class QuantityBL {

    public static boolean Add(Quantity Quantity) {

        return DataAccess.QuantityDA.Add(Quantity);
    }

    public static boolean Update(Quantity Quantity) {

        return DataAccess.QuantityDA.Update(Quantity);
    }

    public static boolean Delete(Quantity Quantity) {

        return DataAccess.QuantityDA.Delete(Quantity);
    }

    public static Quantity GetSingle(int Id) {

        return DataAccess.QuantityDA.GetSingle(Id);
    }

    public static List<Quantity> GetAll() {

        return DataAccess.QuantityDA.GetAll();
    }

    public static List<Quantity> GetAllByPartsId(int PartId) {

        return DataAccess.QuantityDA.GetAllByPartsId(PartId);
    }

    public static Quantity GetSingleByPartId(int PartId) {

        return DataAccess.QuantityDA.GetSingleByPartId(PartId);
    }
}
