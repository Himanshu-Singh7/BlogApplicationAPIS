package com.blogs.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.apis.entites.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
