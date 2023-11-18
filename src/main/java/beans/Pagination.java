package beans;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	private int records;
	private List<Product> listProduct;
	
	public Pagination() {
		
	}

	public Pagination(int records, List<Product> listProduct) {
		super();
		this.records = records;
		this.listProduct = listProduct;
	}

	/**
	 * @return the records
	 */
	public int getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(int records) {
		this.records = records;
	}

	/**
	 * @return the listProduct
	 */
	public List<Product> getListProduct() {
		return listProduct;
	}

	/**
	 * @param listProduct the listProduct to set
	 */
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public List<Product> getProductPerPage(int currentPage){
		List<Product> lp = new ArrayList<>();
		int startIndex = (currentPage - 1)*records;
		int endIndex = Math.min((startIndex + records), listProduct.size());
		for(int i = startIndex; i < endIndex; i++) {
			lp.add(listProduct.get(i));
		}
		return lp;
	}
}
