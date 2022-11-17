package com.categories.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.categories.demo.model.Categories;
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
