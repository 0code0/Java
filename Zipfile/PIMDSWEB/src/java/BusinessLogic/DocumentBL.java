/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Document;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class DocumentBL {

    public static boolean Add(Document document) {

        return DataAccess.DocumentDA.Add(document);
    }

    public static boolean Update(Document document) {

        return DataAccess.DocumentDA.Update(document);
    }

    public static boolean Delete(Document document) {

        return DataAccess.DocumentDA.Delete(document);
    }

    public static Document GetSingle(int Id) {

        return DataAccess.DocumentDA.GetSingle(Id);
    }

    public static List<Document> GetAll() {

        return DataAccess.DocumentDA.GetAll();
    }

    public static List<Document> GetAllByDocumentId(int Id) {

        return DataAccess.DocumentDA.GetAllByDocumentId(Id);
    }

    public static List<Document> GetAllnull() {

        return DataAccess.DocumentDA.GetAllnull();
    }
    
    public static List<Document> GetAllByParentId(int ParentId) {
    
        return DataAccess.DocumentDA.GetAllByParentId(ParentId);
    }
}
