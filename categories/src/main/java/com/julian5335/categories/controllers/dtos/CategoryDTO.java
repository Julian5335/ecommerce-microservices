package com.julian5335.categories.controllers.dtos;

import com.julian5335.categories.repositories.entities.Category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(
  name = "Category",
  description = "The category Schema"
)
public class CategoryDTO {
  
  private Long id;
  private String name;

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
  }

}
