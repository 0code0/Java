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
public class ProjectDetail {
    @Id
    private int Id;
    private String Name;
    private String IPNeed;
    private String Technology;
    private String Version;
    private String Product;
    private String Division;
    private int ProjectCategoryId;
    private int ProjectClassId;
    private String URL;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    @Embedded
    private Base base;

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

    public String getIPNeed() {
        return IPNeed;
    }

    public void setIPNeed(String IPNeed) {
        this.IPNeed = IPNeed;
    }

    public String getTechnology() {
        return Technology;
    }

    public void setTechnology(String Technology) {
        this.Technology = Technology;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String Division) {
        this.Division = Division;
    }

    public int getProjectCategoryId() {
        return ProjectCategoryId;
    }

    public void setProjectCategoryId(int ProjectCategoryId) {
        this.ProjectCategoryId = ProjectCategoryId;
    }

    public int getProjectClassId() {
        return ProjectClassId;
    }

    public void setProjectClassId(int ProjectClassId) {
        this.ProjectClassId = ProjectClassId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
    
    
    
}
