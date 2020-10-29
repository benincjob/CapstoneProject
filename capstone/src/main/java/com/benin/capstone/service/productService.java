package com.benin.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benin.capstone.model.product;
import com.benin.capstone.repository.productRepository;

@Service
public class productService {
	
	@Autowired
	private productRepository ProductRepository;
	public List<product> findAll(){
	  List<product>products = ProductRepository.findAll();
	  return products;
	}
	

}
