package com.benin.capstone.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class customer {
	
	@Id
	@GeneratedValue(generator="customers_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(
			name = "customers_id_seq",
			sequenceName="customers_id_seq",
			allocationSize=1
			)
	private Long customer_id;
	
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="account_number")
	private Long account_number;
	@Column(name="product_id")
	private Long product_id;
	@Column(name="ssn")
	private Long ssn;

	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=product.class)
	private List<product> products;
	
	public customer() {
		super();
	}
	
	public customer(String first_name, String last_name, Long account_number, Long product_id, Long ssn) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.account_number = account_number;
		this.product_id = product_id;
		this.ssn = ssn;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	
	public List<product> getProducts() {
		if(this.products == null) {
			this.products = new ArrayList<product>();
		}
		return products;
	}
	public void setproducts(List<product> products) {
		this.products = products;

	
}

	
}
	