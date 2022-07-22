package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Listen;

import javax.transaction.Transactional;

@Transactional
public interface IListenRepository extends JpaRepository<Listen, Integer> {
    @Modifying
    @Query(value = "update listen set listen_name = :listenName, artist = :artist, category = :category, path_file = :pathFile where id = :id", nativeQuery = true)
    void update(@Param("listenName") String listenName, @Param("artist") String artist, @Param("category") String category, @Param("pathFile") String pathFile, @Param("id") int id);

    @Query(value = "select * from listen where listen_name like :name", nativeQuery = true)
    Page<Listen> findByName(@Param("name") String name, Pageable pageable);
}
