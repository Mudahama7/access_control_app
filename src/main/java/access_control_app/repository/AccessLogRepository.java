package access_control_app.repository;

import access_control_app.model.log.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
