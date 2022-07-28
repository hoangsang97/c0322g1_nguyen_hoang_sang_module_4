package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/showList")
    public ResponseEntity<Page<Category>> showList(@PageableDefault(value = 2, sort = "dateCreate", direction = Sort.Direction.DESC)Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Category category) {
        categoryService.create(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody Category category) {
        if (category == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        categoryService.update(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
