package com.categories.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

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
import com.categories.demo.repository.CategoriesRepository;

@RestController
@RequestMapping("/api")
public class CategoriesController {
	 @Autowired
     CategoriesRepository categoriesRepository;
	
	@GetMapping("/categories")
	public List<Categories> getAllCategories() {
		try {
			return categoriesRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping("/categories")
	public Categories saveAllCategories(@RequestBody Categories categories) {
		try {
			return categoriesRepository.save(categories);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/categories/{Id}")
	public Optional<Categories> getCategoriesById(@PathVariable int id) {
		try {
			return categoriesRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PutMapping("/categories/{id}")
	public Categories updateCategories(@PathVariable("id") int categoriesId,@RequestBody Categories categories) {
		try {
			categories.setCategoriesId(categoriesId);
			return categoriesRepository.save(categories);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping("/categories/{Id}")
	public Boolean deleteCategoriesById(@PathVariable("id") int categoriesId) {
		boolean status=false;
		try {
			categoriesRepository.deleteById(categoriesId);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
