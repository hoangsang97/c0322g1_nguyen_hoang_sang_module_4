package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update blog set name_blog = :nameBlog, content = :content where id = :id", nativeQuery = true)
    void update(@Param("nameBlog") String nameBlog, @Param("content") String content, @Param("id") int id);

    @Query(value = "select * from blog where name_blog like :name", nativeQuery = true)
    Page<Blog> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select b.*, c.name from Blog b join Category c on b.category_id = c.id where c.id = :id",
                    countQuery = "SELECT count(*) FROM Blog b join Category c on b.category_id = c.id WHERE c.id = :id", nativeQuery = true)
    Page<Blog> viewBlog(@Param("id") int id, Pageable pageable);
}
