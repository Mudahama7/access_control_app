package access_control_app.service.mapper;

import access_control_app.dto.new_entity_request.NewUser;
import access_control_app.model.User;
import access_control_app.model.enums.Role;
import access_control_app.service.business_logic.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserMapper {

    private final DepartmentService departmentService;

    public User mapFromDtoReqToEntity(NewUser newUser) {
        User user = new User();

        user.setEmail(newUser.getEmail());
        user.setNomComplete(newUser.getNom());
        user.setRegistrationNumber(newUser.getMatricule());
        user.setRole(Role.FINAL_USER);
        user.setDepartment(departmentService.getDepartment(newUser.getIdDepartment()));

        return user;
    }

}
