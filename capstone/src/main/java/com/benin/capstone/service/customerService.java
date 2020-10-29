package com.benin.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.benin.capstone.model.customer;
import com.benin.capstone.repository.customerRepository;

public class customerService {
	
	@Autowired
	private customerRepository CustomerRepository;
	
	private boolean existsById(Long id) {
		return CustomerRepository.existsById(id);
	}
	
	public List<customer> findAll(){
		List<customer> customers = CustomerRepository.findAll();
		return customers;
		
	}
	public customer findById(Long id) throws Exception {
		customer customer = CustomerRepository.findById(id).orElse(null);
		if(customer == null) {
			throw new Exception("Cannot find Customer with id: " + id);
		}
		else
			return customer;
	}  

	public customer save(customer customer) throws Exception {
		if(!StringUtils.isEmpty(customer.getFirst_name())) {
			if(customer.getCustomer_id() != 0 && existsById(customer.getCustomer_id())) {
				throw new Exception("Contact with id: " + customer.getCustomer_id() +
						" already exists");
			}
			return CustomerRepository.save(customer);
		} else {
			Exception e = new Exception("Failed to save customer");
			throw e; 
		}
	}

	public void update(customer customer) throws Exception {
		if(!StringUtils.isEmpty(customer.getFirst_name())) {
			if(!existsById(customer.getCustomer_id())) {
				throw new Exception("Cannot find Customer with id: " + customer.getCustomer_id());
			}
			
			CustomerRepository.save(customer);
			
		} else {
			Exception e = new Exception("Failed to save customer");
			throw e;
		}
	}
	
	public void deleteById(Long id) throws Exception {
		if(!existsById(id)) {
			throw new Exception("Cannot find customer with id: " + id);
		} else {
			CustomerRepository.deleteById(id);
		}
 	}
	
	public Long count() {
		return CustomerRepository.count();
	}	}


