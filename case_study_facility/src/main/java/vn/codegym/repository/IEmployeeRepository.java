package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Employee;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = " update employee set name = :name, date_of_birth = :date_of_birth, id_card = :id_card, salary = :salary, " +
            " phone_number = :phone_number, email = :email, address = :address, position_id = :position_id, " +
            " education_degree_id = :education_degree_id, division_id = :division_id where id = :id ", nativeQuery = true)
    void update(@Param("name") String name, @Param("date_of_birth") String date_of_birth, @Param("id_card") String id_card
            , @Param("salary") double salary, @Param("phone_number") String phone_number, @Param("email") String email, @Param("address") String address
            , @Param("position_id") int position_id, @Param("education_degree_id") int education_degree_id, @Param("division_id") int division_id
            , @Param("id") int id);

    @Modifying
    @Query(value = "update employee set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from employee where status = 0", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);
}
