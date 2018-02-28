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
public class LegendsDetail {
    @Id
    private int Id;
    private String Name;
    private String Born;
    private String Detail;
    private String FamilyDetail;
    private String ImageUrl;
    private String MoreDetailUrl;
    private String CategoryId;
    
    @Embedded
    private Base base;

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
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

    public String getBorn() {
        return Born;
    }

    public void setBorn(String Born) {
        this.Born = Born;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getFamilyDetail() {
        return FamilyDetail;
    }

    public void setFamilyDetail(String FamilyDetail) {
        this.FamilyDetail = FamilyDetail;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getMoreDetailUrl() {
        return MoreDetailUrl;
    }

    public void setMoreDetailUrl(String MoreDetailUrl) {
        this.MoreDetailUrl = MoreDetailUrl;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

}
