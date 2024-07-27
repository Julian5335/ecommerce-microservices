package com.julian5335.categories.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julian5335.categories.controllers.dtos.CategoryDTO;
import com.julian5335.categories.controllers.requests.AddCategoryRequest;
import com.julian5335.categories.controllers.requests.UpdateCategoryRequest;
import com.julian5335.categories.exceptions.ErrorResponse;
import com.julian5335.categories.exceptions.NotFoundException;
import com.julian5335.categories.services.interfaces.ICategoriesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(
  name = "Categories",
  description = "Collection of apis for categories"
)
public class CategoriesController {
  
  private final ICategoriesService service;

  @GetMapping("categories")
  @Operation(summary = "Get all categories")
  @ApiResponse(
    responseCode = "200",
    description = "Returns a list of categories"
  )
  public List<CategoryDTO> get() {
    return service.get();
  }

  @PostMapping("admins/categories")
  @Operation(summary = "Add a category")
  @ApiResponse(
    responseCode = "201",
    description = "Succesfully adds a category and returns the added category"
  )
  public ResponseEntity<CategoryDTO> add(@Valid @RequestBody AddCategoryRequest request) throws NotFoundException {
    return ResponseEntity
      .status(201)
      .body(service.add(request));
  }

  @PutMapping("admins/categories/{id}")
  @Operation(summary = "Update a category")
  @ApiResponses({
    @ApiResponse(
      responseCode = "200",
      description = "Successfully updates a category and returns the updated category"
    ),
    @ApiResponse(
      responseCode = "404",
      description = "When the category is not found by ID",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class)
      )
    )
  })
  public CategoryDTO update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequest request) throws NotFoundException {
    return service.update(id, request);
  }

  @DeleteMapping("admins/categories/{id}")
  @Operation(summary = "Delete a category")
  @ApiResponses({
    @ApiResponse(
      responseCode = "204",
      description = "Successfully deletes a category and doesn't return any content"
    ),
    @ApiResponse(
      responseCode = "404",
      description = "When the category is not found by ID",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class)
      )
    )
  })
  public void delete(@PathVariable Long id) throws NotFoundException {
    service.delete(id);
  }

}
