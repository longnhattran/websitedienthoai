package beans;

import java.util.Date;
import java.util.List;

public class Orders {
	private int orderId;
	private String username;
	private String address;
	private String phoneNumber;
	private List<Product> lp;
	private int status;
	private String discount;
	private Date orderDate;
	
	public Orders() {
		
	}

	public Orders(String username, String address, String phoneNumber, List<Product> lp, int status, String discount,
			Date orderDate) {
		super();
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.status = status;
		this.discount = discount;
		this.orderDate = orderDate;
	}

	public Orders(int orderId, String username, String address, String phoneNumber, List<Product> lp, int status,
			String discount, Date orderDate) {
		super();
		this.orderId = orderId;
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.status = status;
		this.discount = discount;
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the userMail
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userMail the userMail to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the lp
	 */
	public List<Product> getLp() {
		return lp;
	}

	/**
	 * @param lp the lp to set
	 */
	public void setLp(List<Product> lp) {
		this.lp = lp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}