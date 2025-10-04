package access_control_app.service.business_logic;

import access_control_app.dto.new_entity_request.NewUser;
import access_control_app.model.User;
import jakarta.mail.MessagingException;

public interface UserService {

    User getUserByEmail(String userEmail);

    boolean createFinalUser(NewUser newUser) throws MessagingException;

    User saveUser(User user);

}
