package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
