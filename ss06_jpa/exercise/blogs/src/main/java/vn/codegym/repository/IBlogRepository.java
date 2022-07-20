package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Blog;

import javax.transaction.Transactional;
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Query(value = "update blog set name_blog = :nameBlog, content = :content where id = :id", nativeQuery = true)
    void update(@Param("nameBlog") String nameBlog, @Param("content") String content, @Param("id") int id);
}
