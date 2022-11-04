package rohit.vehicle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(name="admin",schema="targetSchemaName")
public class Admin {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer a_id;
    private String a_user;
    private String a_pass;
    public Admin() {}
    public Admin(String a_user, String a_pass) {
        this.a_user = a_user;
        this.a_pass = a_pass;
    }
    public String getA_user() {
        return a_user;
    }
    public void setA_user(String a_user) {
        this.a_user = a_user;
    }
    public String getA_pass() {
        return a_pass;
    }
    public void setA_pass(String a_pass) {
        this.a_pass = a_pass;
    }
}