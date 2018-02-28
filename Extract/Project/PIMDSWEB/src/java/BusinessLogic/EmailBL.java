package BusinessLogic;

import BusinessObject.Email;


public class EmailBL {

public static boolean sendMail(Email email){
    return DataAccess.EmailDA.sendMail(email);
}    
    
}
