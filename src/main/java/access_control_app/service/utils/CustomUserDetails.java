package access_control_app.service.utils;

import access_control_app.exception.type_exception.UserNotFoundException;
import access_control_app.model.User;
import access_control_app.repository.UserRepository;
import access_control_app.service.mapper.ConnectedUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userRepository;
    private final ConnectedUserMapper connectedUserMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé"));

        return connectedUserMapper.toConnectedUser(user);
    }

}