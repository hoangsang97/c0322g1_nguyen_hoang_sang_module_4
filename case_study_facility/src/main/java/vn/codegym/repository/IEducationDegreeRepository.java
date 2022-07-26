package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.EducationDegree;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
