package com.julian5335.categories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian5335.categories.repositories.entities.Category;

@Repository
public interface CategoriesRepository extends JpaRepository <Category, Long> {

}
