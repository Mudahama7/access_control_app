package access_control_app.service.business_logic;

import access_control_app.model.User;

public interface UserService {

    User getUserByEmail(String userEmail);

}
