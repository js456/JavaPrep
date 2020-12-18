package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	private String producName;
	private int productPrice;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProducName() {
		return producName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProducName(String producName) {
		this.producName = producName;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
