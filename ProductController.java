package com.categories.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.categories.demo.model.Categories;
import com.categories.demo.model.Product;
import com.categories.demo.repository.CategoriesRepository;
import com.categories.demo.repository.ProductReopsitory;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
    ProductReopsitory productReopsitory;
	
	@GetMapping("/product")
	public List<Product> getAllProduct() {
		try {
			return productReopsitory.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping("/product")
	public Product saveAllProduct(@RequestBody Product Product) {
		try {
			return productReopsitory.save(Product);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/product/{Id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		try {
			return productReopsitory.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable("id") int productId,@RequestBody Product product) {
		try {
			product.setProductId(productId);
			return productReopsitory.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping("/product/{Id}")
	public Boolean deleteProductById(@PathVariable("id") int productId) {
		boolean status=false;
		try {
			productReopsitory.deleteById(productId);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
