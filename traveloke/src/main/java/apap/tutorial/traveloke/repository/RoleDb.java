package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDb extends JpaRepository<RoleModel, Long> {
    List<RoleModel> findAll();
}
