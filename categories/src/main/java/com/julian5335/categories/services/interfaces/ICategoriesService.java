package com.julian5335.categories.services.interfaces;

import java.util.List;

import com.julian5335.categories.controllers.dtos.CategoryDTO;
import com.julian5335.categories.controllers.requests.AddCategoryRequest;
import com.julian5335.categories.controllers.requests.UpdateCategoryRequest;
import com.julian5335.categories.exceptions.NotFoundException;

/**
 * 
 */
public interface ICategoriesService {
  
  /**
   * Recursively fetches categories
   * @return a list of categories
   */
  public List<CategoryDTO> get();

  /**
   * Add a category
   * @param request Data with which a new category will be created
   * @return The new category
   * @throws NotFoundException If the parent category is not found
   */
  public CategoryDTO add(AddCategoryRequest request) throws NotFoundException;

  /**
   * Update a category
   * @param id The id of the category to be updated
   * @param request Data with which a new category will be updated
   * @return The updated category
   * @throws NotFoundException If the category or the parent category isnt found
   */
  public CategoryDTO update(Long id, UpdateCategoryRequest request) throws NotFoundException;


  /**
   * Delete a category
   * @param id The id of the category to be deleted
   * @throws NotFoundException if the category cannot be found
   */
  public void delete(Long id) throws NotFoundException;
}
