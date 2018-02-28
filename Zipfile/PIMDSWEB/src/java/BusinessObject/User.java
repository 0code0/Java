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
public class User {
    @Id
    private int Id;
    private String Name;
    private String Email;
    private String Extn;
    private String Address;
    private String Url;
    private String SeatNo;
    private String MobileNo;
    private String EmergencyNo;
    private int EmployeeId;
    private String DateOfBirth;
    private String DateofJoining;
    private String CelebratedDateOfBirth;
    private int ProjectCategoryId;
   
    private String Role;
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getExtn() {
        return Extn;
    }

    public void setExtn(String Extn) {
        this.Extn = Extn;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(String SeatNo) {
        this.SeatNo = SeatNo;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public String getEmergencyNo() {
        return EmergencyNo;
    }

    public void setEmergencyNo(String EmergencyNo) {
        this.EmergencyNo = EmergencyNo;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getDateofJoining() {
        return DateofJoining;
    }

    public void setDateofJoining(String DateofJoining) {
        this.DateofJoining = DateofJoining;
    }

    public String getCelebratedDateOfBirth() {
        return CelebratedDateOfBirth;
    }

    public void setCelebratedDateOfBirth(String CelebratedDateOfBirth) {
        this.CelebratedDateOfBirth = CelebratedDateOfBirth;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public int getProjectCategoryId() {
        return ProjectCategoryId;
    }

    public void setProjectCategoryId(int ProjectCategoryId) {
        this.ProjectCategoryId = ProjectCategoryId;
    }
    
    
    
    
}
