package com.julian5335.categories.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.julian5335.categories.controllers.dtos.CategoryDTO;
import com.julian5335.categories.controllers.requests.AddCategoryRequest;
import com.julian5335.categories.controllers.requests.UpdateCategoryRequest;
import com.julian5335.categories.exceptions.NotFoundByIdException;
import com.julian5335.categories.exceptions.NotFoundException;
import com.julian5335.categories.repositories.CategoriesRepository;
import com.julian5335.categories.repositories.entities.Category;
import com.julian5335.categories.services.interfaces.ICategoriesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService implements ICategoriesService {
  
  private final CategoriesRepository repository;

  @Override
  public List<CategoryDTO> get() {
    return repository
      .findAll()
      .stream()
      .map(x -> new CategoryDTO(x))
      .collect(Collectors.toList());
  }

  @Override
  public CategoryDTO add(AddCategoryRequest request) throws NotFoundException {
    Category category = new Category(null, request.getName());
    category = repository.save(category);
    return new CategoryDTO(category);
  }
  
  @Override
  public CategoryDTO update(Long id, UpdateCategoryRequest request) throws NotFoundException {
    Category category = repository
      .findById(id)
      .orElseThrow(() -> new NotFoundByIdException());

    category.update(request);
    category = repository.save(category);

    return new CategoryDTO(category);
  }

  @Override
  public void delete(Long id) throws NotFoundException {
    Category category = repository
      .findById(id)
      .orElseThrow(() -> new NotFoundByIdException());

    // TODO: Cannot delete a category with products

    repository.delete(category);
  }

}
