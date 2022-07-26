package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Facility;

import javax.transaction.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility f " +
            " join facility_type t on f.facility_type_id = t.id" +
            " where f.facility_type_id = :id and status = 0 ",
            countQuery = "select count (*) from facility f " +
                    " join facility_type t on f.facility_type_id = t.id " +
                    " where f.facility_type_id = :id and status = 0 ", nativeQuery = true)
    Page<Facility> facilityAllById(@Param("id") int id, Pageable pageable);

    @Modifying
    @Query(value = "update facility set name = :name, area = :area, cost = :cost, max_people = :max_people, rent_type_id = :rent_type_id," +
            " facility_type_id =:facility_type_id, standard_room = :standard_room, description_other_convenience = :description_other_convenience, " +
            " pool_area = :pool_area, number_of_floors = :number_of_floors, facility_free = :facility_free where id = :id", nativeQuery = true)
    void update(@Param("name") String name, @Param("area") int area, @Param("cost") double cost,
                @Param("max_people") int max_people, @Param("rent_type_id") int rent_type_id, @Param("facility_type_id") int facility_type_id
            , @Param("standard_room") String standard_room, @Param("description_other_convenience") String description_other_convenience, @Param("pool_area") double pool_area
            , @Param("number_of_floors") int number_of_floors, @Param("facility_free") String facility_free, @Param("id") int id);

    @Modifying
    @Query(value = "update facility set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from facility f " +
            " join facility_type t on f.facility_type_id = t.id where status = 0",
            countQuery = " select count(*) from facility f " +
                    " join facility_type t on f.facility_type_id = t.id where status = 0 ", nativeQuery = true)
    Page<Facility> findAllFacility(Pageable pageable);
}
