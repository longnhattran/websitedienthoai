package beans;

public class ProductOrders {
	private int orderId;
	private int productId;
	private int numberProduct;
	private String nameProduct;
	
	public ProductOrders() {
		
	}

	public ProductOrders(int orderId, int productId, int numberProduct, String nameProduct) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.numberProduct = numberProduct;
		this.nameProduct = nameProduct;
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
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the numberProduct
	 */
	public int getNumberProduct() {
		return numberProduct;
	}

	/**
	 * @param numberProduct the numberProduct to set
	 */
	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

	/**
	 * @return the nameProduct
	 */
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * @param nameProduct the nameProduct to set
	 */
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
}