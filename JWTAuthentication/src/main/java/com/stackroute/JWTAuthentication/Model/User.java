package com.stackroute.JWTAuthentication.Model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "User_Records")
public class User {
    @Id
    @Column(name = "email",unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email
    private String id;


    @NotBlank(message = "password is mandatory")
    private String password;

    @Column(name = "firstname")

    @NotBlank(message = "FirstName is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @NotBlank(message = "Phone Number is required")
    private String phoneNo;

    public User() {
        super();
    }

    public User(String id, String password, String firstname, String lastname, String phoneNo) {
        this.id = id;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
