package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	private String purchaseDt;
	private int userId;
	private int totalUnit;
	private double totalCostPrice;

//	@ManyToOne
//	 @JoinColumns({
//	        @JoinColumn(name = "buyer_id",  referencedColumnName = "u_id"),
//	        @JoinColumn(name = "seller_id", referencedColumnName = "u_id")
//	    })
//	private Person user;

	@ManyToOne
	@JoinColumn(name = "buyer_id", referencedColumnName = "u_id")
	private Person buyer;

	@ManyToOne
	@JoinColumn(name = "seller_id", referencedColumnName = "u_id")
	private Person seller;

	@ManyToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "prod_id")
	private Product product;

	public Purchase() {
		super();
	}

	public Purchase(int purchaseId, String purchaseDt, int userId, int totalUnit, double totalCostPrice, Person buyer,
			Person seller, Product product) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseDt = purchaseDt;
		this.userId = userId;
		this.totalUnit = totalUnit;
		this.totalCostPrice = totalCostPrice;
		this.buyer = buyer;
		this.seller = seller;
		this.product = product;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseDt() {
		return purchaseDt;
	}

	public void setPurchaseDt(String purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(int totalUnit) {
		this.totalUnit = totalUnit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalCostPrice() {
		return totalCostPrice;
	}

	public void setTotalCostPrice(double totalCostPrice) {
		this.totalCostPrice = totalCostPrice;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}

	public Person getSeller() {
		return seller;
	}

	public void setSeller(Person seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseDt=" + purchaseDt + ", userId=" + userId
				+ ", totalUnit=" + totalUnit + ", totalCostPrice=" + totalCostPrice + ", buyer=" + buyer + ", seller="
				+ seller + ", product=" + product + "]";
	}

}
