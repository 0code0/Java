/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author singhj1
 */
@Entity
public class Quantity{

@Id    
    private int Id;
    private String Count;
    private int PartsId;

    public int getPartsId() {
        return PartsId;
    }

    public void setPartsId(int PartsId) {
        this.PartsId = PartsId;
    }
    
    @Embedded
    private Base base;

    public Quantity(){
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
    
    
    
    
}
