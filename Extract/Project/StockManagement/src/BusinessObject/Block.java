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
public class Block {
    @Id
    private int Id;
    private String Name;
    private int BuildingId;
   
    @Embedded
    private Base base;

    public Base getBase() {
        return base;
    }
    public void setBase(Base base) {
        this.base = base;
    }
    public Block() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getBuildingId() {
        return BuildingId;
    }

    public void setBuildingId(int BuildingId) {
        this.BuildingId = BuildingId;
    }

    
    
    
}
