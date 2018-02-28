/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.DocumentCategory;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class DocumentCategoryBL {

    public static boolean Add(DocumentCategory documentCategory) {

        return DataAccess.DocumentCategoryDA.Add(documentCategory);
    }

    public static boolean Update(DocumentCategory documentCategory) {

        return DataAccess.DocumentCategoryDA.Update(documentCategory);

    }

    public static boolean Delete(DocumentCategory documentCategory) {

        return DataAccess.DocumentCategoryDA.Delete(documentCategory);
    }

    public static DocumentCategory GetSingle(int Id) {

        return DataAccess.DocumentCategoryDA.GetSingle(Id);
    }

    public static List<DocumentCategory> GetAll() {

        return DataAccess.DocumentCategoryDA.GetAll();
    }
}
