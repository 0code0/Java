/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author singhj1
 */
public class Base {
    
    private String IsApproved;
    private String IsDeleted;
    private String CreatedBy;
    private String CreatedOn;

    public String getIsApproved() {
        return IsApproved;
    }

    public void setIsApproved(String IsApproved) {
        this.IsApproved = IsApproved;
    }

    public String getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(String IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String CreatedOn) {
        this.CreatedOn = CreatedOn;
    }
    
    
    
}
