package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("blog/api/v1")
@CrossOrigin
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/{id}/{page}")
    public ResponseEntity<Page<Blog>> showList(@PathVariable int id, @PageableDefault(value = 10) Pageable pageable, @PathVariable int page) {
        Page<Blog> blogList = blogService.viewBlog(id, pageable.withPage(page));
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Blog blog) {
        blog.setDateCreate(new Date(System.currentTimeMillis()));
        blogService.create(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping ("/edit")
    public ResponseEntity edit(@RequestBody Blog blog) {
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        blogService.update(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping ("/delete")
    public ResponseEntity delete(@RequestParam int id) {
        blogService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<Blog> view(@RequestParam int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@RequestParam String name,
                         @PageableDefault(value = 2)Pageable pageable) {
        Page<Blog> blogPage = blogService.search(name, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
