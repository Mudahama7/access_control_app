package access_control_app.service.utils;

import access_control_app.model.User;
import access_control_app.service.business_logic.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConnectedUserGetter {

    private final UserService userService;

    public User getConnectedUser(){
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUserByEmail(userEmail);
    }

}