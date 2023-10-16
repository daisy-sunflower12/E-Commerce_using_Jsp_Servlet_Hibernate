package com.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id")
	private int id;
	private String prodName;
	private String prodDesc;
	private String prodImg;
	private Double prodSellPrice;
	private Double prodCostPrice;
	private int stockUnit;
	private Date createdDate;
	@Column(columnDefinition = "TINYINT(1) DEFAULT 1")
	private byte isDeleted;

	@ManyToOne()
	@JoinColumn(name = "person_id")
	private Person person;

	@OneToMany(mappedBy = "product")
	private List<Purchase> purchases;

	public Product() {
		super();

	}

	public Product(int id, String prodName, String prodDesc, String prodImg, Double prodSellPrice, Double prodCostPrice,
			int stockUnit, Date createdDate, byte isDeleted, Person person) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodImg = prodImg;
		this.prodSellPrice = prodSellPrice;
		this.prodCostPrice = prodCostPrice;
		this.stockUnit = stockUnit;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	public Double getProdSellPrice() {
		return prodSellPrice;
	}

	public void setProdSellPrice(Double prodSellPrice) {
		this.prodSellPrice = prodSellPrice;
	}

	public Double getProdCostPrice() {
		return prodCostPrice;
	}

	public void setProdCostPrice(Double prodCostPrice) {
		this.prodCostPrice = prodCostPrice;
	}

	public int getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(int stockUnit) {
		this.stockUnit = stockUnit;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodImg=" + prodImg
				+ ", prodSellPrice=" + prodSellPrice + ", prodCostPrice=" + prodCostPrice + ", stockUnit=" + stockUnit
				+ ", createdDate=" + createdDate + ", isDeleted=" + isDeleted + "]";
	}

}
