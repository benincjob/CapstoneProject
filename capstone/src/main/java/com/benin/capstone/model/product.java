package com.benin.capstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class product {
	
	@Id
	@GeneratedValue(generator="products_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(
			name = "products_id_seq",
			sequenceName="products_id_seq",
			allocationSize=1
			)
	private Long product_id;
	
	
	@Column(name="product_description")
	private String product_description;
	
	@Column(name="interest_rate")
	private Long interest_rate;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private customer customer;
	
	public product() {
		super();
	
	}

	public product(String product_description, Long interest_rate) {
		super();
		this.product_description = product_description;
		this.interest_rate = interest_rate;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public long getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(Long interest_rate) {
		this.interest_rate = interest_rate;
	}
	

}
