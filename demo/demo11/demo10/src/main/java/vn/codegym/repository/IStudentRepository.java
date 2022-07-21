package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.model.Student;

import javax.transaction.Transactional;

@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = " select s.* from student s " +
            " left join account a on s.account_id = a.id " +
            " left join class_room c on s.class_room_id = c.id ", nativeQuery = true)
    Page<Student> findAllStudent(Pageable pageable);
}
