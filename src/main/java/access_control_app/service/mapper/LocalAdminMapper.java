package access_control_app.service.mapper;

import access_control_app.dto.new_entity_request.NewAdminLocal;
import access_control_app.model.User;
import access_control_app.model.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class LocalAdminMapper {

    public User mapFromAdminReqToEntity(NewAdminLocal newAdminLocal) {
        User user = new User();

        user.setNomComplete(newAdminLocal.getNomComplete());
        user.setEmail(newAdminLocal.getEmail());
        user.setRole(Role.LOCAL_ADMINISTRATOR);

        return user;
    }

}
