/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessObject.Comment;
import java.util.List;

/**
 *
 * @author singhj1
 */
public class CommentBL {

    public static boolean Add(Comment comment) {

        return DataAccess.CommentDA.Add(comment);
    }

    public static boolean Update(Comment comment) {

        return DataAccess.CommentDA.Update(comment);
    }

    public static boolean Delete(Comment comment) {

        return DataAccess.CommentDA.Delete(comment);
    }

    public static Comment GetSingle(int Id) {

        return DataAccess.CommentDA.GetSingle(Id);
    }

    public static List<Comment> GetAll() {

        return DataAccess.CommentDA.GetAll();
    }

    public static List<Comment> GetAllByParentId(int ParentId) {

        return DataAccess.CommentDA.GetAllByParentId(ParentId);
    }

    public static List<Comment> GetAllnull() {

        return DataAccess.CommentDA.GetAllnull();
    }

    public static List<Comment> GetAllTop3() {

        return DataAccess.CommentDA.GetAllTop3();
    }

    public static List<Comment> GetAllByProjectDocument(int ProjectDocumentId) {

        return DataAccess.CommentDA.GetAllByProjectDocument(ProjectDocumentId);
    }

    public static List<Comment> GetAllByProjectDocumentAndParentId(int ProjectDocumentId) {

        return DataAccess.CommentDA.GetAllByProjectDocumentAndParentId(ProjectDocumentId);
    }
}
