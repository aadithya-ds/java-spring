package springboot.authentication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.authentication.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
