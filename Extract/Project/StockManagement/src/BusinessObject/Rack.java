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
public class Rack {
    @Id
    private int ID;
    private String Name;
    private int BlockID;
   @Embedded
    private Base base;
    
    public Rack(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getBlockID() {
        return BlockID;
    }

    public void setBlockID(int BlockID) {
        this.BlockID = BlockID;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    
    
    
    
    
    
}
