package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Customer;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(value = "update customer set customer_type_id = :customer_type_id, name = :name, date_of_birth =:date_of_birth, gender =:gender, " +
            " id_card =:id_card, phone_number =:phone_number, email =:email, address =:address where id =:id", nativeQuery = true)
    void update(@Param("customer_type_id") int customer_type_id, @Param("name") String name, @Param("date_of_birth") String date_of_birth,
                @Param("gender") int gender, @Param("id_card") String id_card, @Param("phone_number") String phone_number, @Param("email") String email,
                @Param("address") String address, @Param("id") int id);

    @Modifying
    @Query(value = "update customer set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from customer where status = 0", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Query(value = "select * from customer where name like :name and status = 0", nativeQuery = true)
    Page<Customer> search(@Param("name") String name, Pageable pageable);
}
