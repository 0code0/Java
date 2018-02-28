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
public class Used  {

@Id    
    private int Id;
    private int PeopleId;
    private int PartId;
    private String Count;
  
@Embedded
    private Base base; 
    
    public Used(){
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPeopleId() {
        return PeopleId;
    }

    public void setPeopleId(int PeopleId) {
        this.PeopleId = PeopleId;
    }

  
    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
    
   public int getPartId() {
        return PartId;
    }

    public void setPartId(int PartId) {
        this.PartId = PartId;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }
    
    
    
}
