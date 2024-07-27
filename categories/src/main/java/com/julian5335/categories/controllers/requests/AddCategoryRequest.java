package com.julian5335.categories.controllers.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(
  name = "Add Category Request",
  description = "Request to add a category"
)
public class AddCategoryRequest {

  @NotEmpty
  @Size(min = 2, max = 30)
  private String name;

}
