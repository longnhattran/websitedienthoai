package beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public void add(Product ci) {
		for(Product item : items) {
			if(ci.getId() == item.getId()) {
				item.setNumber(item.getNumber() + 1);
				return;
			}
		}
		
		items.add(ci);
	}
	
	
	public void remove(int id) {
		for(Product item : items) {
			if(id == item.getId()) {
				items.remove(item);
				return;
			}
		}
	}
	
	public double getTotalAmount() {
		double amount = 0;
		for(Product item : items) {
			amount += item.getNumber()*item.getPrice();
		}
		
		return Math.round(amount*100.0)/100.0;
	}
	/**
	 * @return the items
	 */
	public List<Product> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
}
