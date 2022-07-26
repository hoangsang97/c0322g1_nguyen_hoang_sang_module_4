package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "select * from attach_facility a " +
            " join contract_detail cd on a.id = cd.attach_facility_id " +
            " join contract c on cd.contract_id = c.id " +
            " where c.id = :id ",
            countQuery = "select count(*) from attach_facility a " +
                    " join contract_detail cd on a.id = cd.attach_facility_id " +
                    " join contract c on cd.contract_id = c.id " +
                    " where c.id = :id ",nativeQuery = true)
    List<AttachFacility> findAllAttachFacility(@Param("id") int id);
}
