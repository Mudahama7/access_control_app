package access_control_app.service.mapper;

import access_control_app.model.User;
import access_control_app.model.auth.ConnectedUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ConnectedUserMapper {

    public UserDetails toConnectedUser(User user) {
        return ConnectedUser.builder()
                .authorities(user.getRole().getGrantedAuthorities())
                .emailAsUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
