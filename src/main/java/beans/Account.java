package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import context.DBContext;

public class Account {
	private String email, pwd;
	
	private int role;
	
	private String name, address, phone;

	public Account() {
		
	}

	public Account(String email, String pwd, int role, String name, String address, String phone) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	/**
	 * @return the usr
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param usr the usr to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean validate() {
		// TODO Auto-generated method stub
		String regrexEmail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regrexPassword = "[a-zA-Z0-9_!@#$%^&*]+";
		
		return email.matches(regrexEmail) && pwd.matches(regrexPassword);
	}
}
