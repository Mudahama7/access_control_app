package access_control_app.repository;

import access_control_app.model.log.UserActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActionLogRepository extends JpaRepository<UserActionLog, Long> {
}
