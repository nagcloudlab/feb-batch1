package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.product.Product;
import com.example.core.product.ProductService;
import com.example.exceptions.InvalidInputException;
import com.example.exceptions.NotFoundException;
import com.example.http.ServiceUtil;

@RestController
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ServiceUtil serviceUtil;

	@Autowired
	public ProductServiceImpl(ServiceUtil serviceUtil) {
		this.serviceUtil = serviceUtil;
	}

	@Override
	public Product getProduct(int productId) {
		LOG.debug("/product return the found product for productId={}", productId);
		if (productId < 1) {
			throw new InvalidInputException("Invalid productId: " + productId);
		}
		if (productId == 13) {
			throw new NotFoundException("No product found for productId: " + productId);
		}
		return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
	}
	
}
