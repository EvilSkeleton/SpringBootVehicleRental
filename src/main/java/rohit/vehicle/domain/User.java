package rohit.vehicle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(name="user",schema="targetSchemaName")
public class User {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer u_id;
    private String u_name;
    private String u_addr;
    private String u_status;
    private String u_phone;
    private String u_email;
    private String u_username;
    private String u_password;
    public User() {}
    public User(Integer u_id, String u_name, String u_addr, String u_status, String u_phone, String u_email,
            String u_username, String u_password) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_addr = u_addr;
        this.u_status = u_status;
        this.u_phone = u_phone;
        this.u_email = u_email;
        this.u_username = u_username;
        this.u_password = u_password;
    }
    public Integer getU_id() {
        return u_id;
    }
    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
    public String getU_addr() {
        return u_addr;
    }
    public void setU_addr(String u_addr) {
        this.u_addr = u_addr;
    }
    public String getU_status() {
        return u_status;
    }
    public void setU_status(String u_status) {
        this.u_status = u_status;
    }
    public String getU_phone() {
        return u_phone;
    }
    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }
    public String getU_email() {
        return u_email;
    }
    public void setU_email(String u_email) {
        this.u_email = u_email;
    }
    public String getU_username() {
        return u_username;
    }
    public void setU_username(String u_username) {
        this.u_username = u_username;
    }
    public String getU_password() {
        return u_password;
    }
    public void setU_password(String u_password) {
        this.u_password = u_password;
    }
}