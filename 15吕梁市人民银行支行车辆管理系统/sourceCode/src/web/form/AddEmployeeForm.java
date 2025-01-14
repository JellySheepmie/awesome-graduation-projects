/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package web.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2002
 * 
 * XDoclet definition:
 * @struts.form name="addEmployeeForm"
 */
public class AddEmployeeForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** phone property */
	private String phone;

	/** gender property */
	private String gender;

	/** cartype property */
	private String cartype;

	/** age property */
	private long age;

	/** descripe property */
	private String descripe;

	/** licensenum property */
	private String licensenum;

	/** educationlevel property */
	private String educationlevel;

	/** position property */
	private String position;

	/** address property */
	private String address;

	/** name property */
	private String name;

	/*
	 * Generated Methods
	 */
	/** 
	 * Returns the phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/** 
	 * Set the phone.
	 * @param phone The phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** 
	 * Returns the gender.
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/** 
	 * Set the gender.
	 * @param gender The gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/** 
	 * Returns the cartype.
	 * @return String
	 */
	public String getCartype() {
		return cartype;
	}

	/** 
	 * Set the cartype.
	 * @param cartype The cartype to set
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	/** 
	 * Returns the age.
	 * @return Long
	 */
	public long getAge() {
		return age;
	}

	/** 
	 * Set the age.
	 * @param age The age to set
	 */
	public void setAge(long age) {
		this.age = age;
	}

	/** 
	 * Returns the descripe.
	 * @return String
	 */
	public String getDescripe() {
		return descripe;
	}

	/** 
	 * Set the descripe.
	 * @param descripe The descripe to set
	 */
	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	/** 
	 * Returns the licensenum.
	 * @return String
	 */
	public String getLicensenum() {
		return licensenum;
	}

	/** 
	 * Set the licensenum.
	 * @param licensenum The licensenum to set
	 */
	public void setLicensenum(String licensenum) {
		this.licensenum = licensenum;
	}

	/** 
	 * Returns the educationlevel.
	 * @return String
	 */
	public String getEducationlevel() {
		return educationlevel;
	}

	/** 
	 * Set the educationlevel.
	 * @param educationlevel The educationlevel to set
	 */
	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}

	/** 
	 * Returns the position.
	 * @return String
	 */
	public String getPosition() {
		return position;
	}

	/** 
	 * Set the position.
	 * @param position The position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/** 
	 * Returns the address.
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/** 
	 * Set the address.
	 * @param address The address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}