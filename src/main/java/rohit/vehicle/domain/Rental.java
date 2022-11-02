package rohit.vehicle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(name="vehicle",schema="targetSchemaName")
public class Rental {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer v_id;
    private String v_name;
    private String v_status;
    private String v_model;
	private String v_cust;
    public Rental() {}
	public Rental(Integer v_id, String v_name, String v_status, String v_model,String v_cust) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_status = v_status;
		this.v_model = v_model;
		this.v_cust = v_cust;
	}
	public Integer getV_id() {
		return v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public String getV_status() {
		return v_status;
	}
	public String getV_model() {
		return v_model;
	}
	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public void setV_status(String v_status) {
		this.v_status = v_status;
	}
	public void setV_model(String v_model) {
		this.v_model = v_model;
	}
	public String getV_cust() {
		return v_cust;
	}
	public void setV_cust(String v_cust) {
		this.v_cust = v_cust;
	}
}